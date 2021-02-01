package usantatecla.mastermind.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ProposedCombinationTest {

    private static final List<Color> COLOR = Arrays.asList(
            Color.GREEN,
            Color.CYAN,
            Color.RED,
            Color.MAGENTA);

    @Test
    public void testGivenProposedCombinationWithColorsWhenGetColorsThenReturn() {
        assertThat(new ProposedCombination(ProposedCombinationTest.COLOR).getColors(), is(ProposedCombinationTest.COLOR));
    }

    @Test
    public void testGivenProposedCombinationWhenGetErrorThenWrongLengthError() {
        assertThat(ProposedCombination.getError(Color.get("")), is(Error.WRONG_LENGTH));
        assertThat(ProposedCombination.getError(Color.get("rg")), is(Error.WRONG_LENGTH));
        assertThat(ProposedCombination.getError(Color.get("rgbcy")), is(Error.WRONG_LENGTH));
        assertThat(ProposedCombination.getError(Color.get("rgasdvbnxcjkvbiasd24563")), is(Error.WRONG_LENGTH));
    }

    @Test
    public void testGivenProposedCombinationWhenGetErrorThenWrongCharactersError() {
        assertThat(ProposedCombination.getError(Color.get("rg5c")), is(Error.WRONG_CHARACTERS));
        assertThat(ProposedCombination.getError(Color.get("7362")), is(Error.WRONG_CHARACTERS));
        assertThat(ProposedCombination.getError(Color.get("ç{}+")), is(Error.WRONG_CHARACTERS));
    }

    @Test
    public void testGivenProposedCombinationWhenGetErrorThenDuplicatedError() {
        assertThat(ProposedCombination.getError(Color.get("bgbc")), is(Error.DUPLICATED));
        assertThat(ProposedCombination.getError(Color.get("bbbb")), is(Error.DUPLICATED));
        assertThat(ProposedCombination.getError(Color.get("cygc")), is(Error.DUPLICATED));
    }

    @Test
    public void testGivenProposedCombinationWhenGetErrorThenNullError() {
        assertThat(ProposedCombination.getError(Color.get("rgby")), is(Error.NULL));
    }

    @Test
    public void testGivenColorsInProposedCombinationWhenColorIsContainedByPositionOutOfSizeThenIsAssert() {
        Assertions.assertThrows(AssertionError.class,
                () -> new ProposedCombination(ProposedCombinationTest.COLOR).contains(ProposedCombinationTest.COLOR.get(0), 10));
    }

}
