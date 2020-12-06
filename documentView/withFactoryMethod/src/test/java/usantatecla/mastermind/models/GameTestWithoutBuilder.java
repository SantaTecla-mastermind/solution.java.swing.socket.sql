package usantatecla.mastermind.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usantatecla.mastermind.types.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GameTestWithoutBuilder {

    private Game game;

    @BeforeEach
    void before() {
        this.game = new Game();
    }

    @Test
    void testGivenEmptyGameInstanceWhenIsLooserOrWinnerThenIsFalse() {
        assertThat(this.game.isLooser(), is(equalTo(false)));
        assertThat(this.game.isWinner(), is(equalTo(false)));
    }

    @Test
    void testGivenEmptyGameInstanceWhenGetAttemptsThenIs0() {
        assertThat(this.game.getAttempts(), is(equalTo(0)));
    }


    @Test
    void testGivenNineAttemptsGameWhenPlaceAnotherProposedCombinationThenIsLooser() {
        ArrayList<Color> colors = new ArrayList<>(Arrays.asList(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW));
        ProposedCombination combination = new ProposedCombination();
        combination.colors = colors;
        for (int i = 0; i < 9; i++) {
            this.game.addProposedCombination(combination);
        }
        assertThat(this.game.isLooser(), is(false));

        this.game.addProposedCombination(combination);
        assertThat(this.game.isLooser(), is(true));
    }

    @Test
    void testGivenGameWith1ProposedCombinationWhenGetProposedCombinationAtPosition0ThenReturnsThatProposedCombination() {
        ArrayList<Color> colors = new ArrayList<>(Arrays.asList(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW));
        ProposedCombination combination = new ProposedCombination();
        combination.colors = colors;
        this.game.addProposedCombination(combination);

        assertThat(this.game.getProposedCombination(0), is(equalTo(combination)));
    }

    @Test
    void testGivenGameWith3ProposedCombinationsWhenGetAttemptsThenReturns3() {
        ArrayList<Color> colors = new ArrayList<>(Arrays.asList(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW));
        ProposedCombination combination = new ProposedCombination();
        combination.colors = colors;
        this.game.addProposedCombination(combination);
        this.game.addProposedCombination(combination);
        this.game.addProposedCombination(combination);

        assertThat(this.game.getAttempts(), is(3));
    }

    @Test
    void testGivenGameWith1ProposedCombinationWhenGetResultAt0ThenReturnsValidResult() {
        ArrayList<Color> colors = new ArrayList<>(Arrays.asList(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW));
        ProposedCombination combination = new ProposedCombination();
        combination.colors = colors;
        this.game.addProposedCombination(combination);

        assertThat(this.game.getResult(0), notNullValue(Result.class));
    }

    @Test
    void testGivenGameInAnyStateWhenResetThenIsEmpty() {
        ArrayList<Color> colors = new ArrayList<>(Arrays.asList(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW));
        ProposedCombination combination = new ProposedCombination();
        combination.colors = colors;
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < random.nextInt(10); i++) {
            this.game.addProposedCombination(combination);
        }

        this.game.reset();

        assertThat(this.game.getAttempts(), is(0));
        assertThat(this.game.isLooser(), is(false));
        assertThat(this.game.isWinner(), is(false));
        Assertions.assertThrows(AssertionError.class, () -> this.game.getProposedCombination(0));
        Assertions.assertThrows(AssertionError.class, () -> this.game.getResult(0));
    }
}
