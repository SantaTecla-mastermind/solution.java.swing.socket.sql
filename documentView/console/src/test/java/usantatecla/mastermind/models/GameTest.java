package usantatecla.mastermind.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import usantatecla.mastermind.types.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GameTest {

    private Game game;

    private void setGame(String... proposedCombinationStrings) {
        this.game = new GameBuilder().proposedCombinations(proposedCombinationStrings).build();
    }

    private void setGame(int times) {
        this.game = new GameBuilder().proposedCombinations(times, "rbgy").build();
    }

    @Test
    void testGivenEmptyGameInstanceWhenIsLooserOrWinnerThenIsFalse() {
        this.setGame();
        assertThat(this.game.isLooser(), is(equalTo(false)));
        assertThat(this.game.isWinner(), is(equalTo(false)));
    }

    @Test
    void testGivenEmptyGameInstanceWhenGetAttemptsThenIs0() {
        this.setGame();
        assertThat(this.game.getAttempts(), is(0));
    }


    @Test
    void testGivenNineAttemptsGameWhenPlaceAnotherProposedCombinationThenIsLooser() {
        this.setGame(9);
        assertThat(this.game.isLooser(), is(false));
        this.setGame(10);
        assertThat(this.game.isLooser(), is(true));
    }

    @Test
    void testGivenGameWith1ProposedCombinationWhenGetProposedCombinationAtPosition0ThenReturnsThatProposedCombination() {
        this.setGame("rbgy");

        ArrayList<Color> colors = new ArrayList<>(Arrays.asList(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW));
        assertThat(this.game.getProposedCombination(0).getColors(), is(colors));
    }

    @Test
    void testGivenGameWith3ProposedCombinationsWhenGetAttemptsThenReturns3() {
        this.setGame(3);

        assertThat(this.game.getAttempts(), is(3));
    }

    @Test
    void testGivenGameWith1ProposedCombinationWhenGetResultAt0ThenReturnsValidResult() {
        this.setGame("rbgy");

        assertThat(this.game.getResult(0), notNullValue(Result.class));
    }

    @Test
    void testGivenGameInAnyStateWhenResetThenIsEmpty() {
        Random random = new Random(System.currentTimeMillis());
        int length = random.nextInt(10);
        this.setGame(length);

        this.game.reset();

        assertThat(this.game.getAttempts(), is(0));
        assertThat(this.game.isLooser(), is(false));
        Assertions.assertThrows(AssertionError.class, () -> this.game.getProposedCombination(0));
        Assertions.assertThrows(AssertionError.class, () -> this.game.getResult(0));
    }
}
