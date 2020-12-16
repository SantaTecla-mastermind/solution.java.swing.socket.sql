package usantatecla.mastermind.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import usantatecla.mastermind.types.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class SessionTest {

    private Session session;

    private void setSession(String... proposedCombinationStrings) {
        this.session = new SessionBuilder().proposedCombinations(proposedCombinationStrings).build();
    }

    private void setSession(int times) {
        this.session = new SessionBuilder().proposedCombinations(times, "rbgy").build();
    }

    @Test
    void testGivenEmptySessionInstanceWhenRedoableOrUndoableThenIsFalse() {
        this.setSession();
        assertThat(this.session.undoable(), is(equalTo(false)));
        assertThat(this.session.redoable(), is(equalTo(false)));
    }

    @Test
    void testGiven1ProposedCombinationSessionWhenUndoableThenIsTrue() {
        this.setSession(1);
        assertThat(this.session.undoable(), is(equalTo(true)));
    }

    @Test
    void testGiven1ProposedCombinationSessionWhenRedoableThenIsFalse() {
        this.setSession(1);
        assertThat(this.session.redoable(), is(equalTo(false)));
    }

    @Test
    void testGiven2ProposedCombinationSessionWhenUndoThenIsRedoable() {
        this.setSession(2);
        this.session.undo();
        assertThat(this.session.redoable(), is(equalTo(true)));
    }

    @Test
    void testGiven2ProposedCombinationSessionWhenUndoThenGameHasOnlyOneAttemptAndProposedCombination() {
        this.setSession("rgby", "opgb");
        assertThat(this.session.getAttempts(), is(2));

        this.session.undo();
        assertThat(this.session.getAttempts(), is(1));
        Assertions.assertThrows(AssertionError.class, () -> this.session.getColors(1));
        Assertions.assertThrows(AssertionError.class, () -> this.session.getBlacks(1));
    }

    @Test
    void testGivenAnySessionWhen3XUndoAnd2XRedoThenCorrectGameStateIsGivenAndIsUndoableAndRedoable() {
        this.setSession("rgby", "opgb", "porg", "bgoy");
        assertThat(this.session.getAttempts(), is(4));
        this.session.undo();
        this.session.undo();
        this.session.undo();
        this.session.redo();
        this.session.redo();

        assertThat(this.session.getAttempts(), is(3));
        assertThat(this.session.getColors(2), is(Arrays.asList(Color.PURPLE, Color.ORANGE, Color.RED, Color.GREEN)));
        Assertions.assertThrows(AssertionError.class, () -> this.session.getColors(3));
        Assertions.assertThrows(AssertionError.class, () -> this.session.getWhites(3));
        assertThat(this.session.undoable(), is(equalTo(true)));
        assertThat(this.session.redoable(), is(equalTo(true)));
    }

    @Test
    void testGivenAnySessionWhenClearGameThenSessionIsClearedCorrectly() {
        this.setSession("rgby", "opgb", "porg", "bgoy");
        assertThat(this.session.getAttempts(), is(4));
        this.session.clearGame();

        assertThat(this.session.getAttempts(), is(0));
        Assertions.assertThrows(AssertionError.class, () -> this.session.getColors(0));
        Assertions.assertThrows(AssertionError.class, () -> this.session.getWhites(0));
        assertThat(this.session.undoable(), is(equalTo(false)));
        assertThat(this.session.redoable(), is(equalTo(false)));
    }

}
