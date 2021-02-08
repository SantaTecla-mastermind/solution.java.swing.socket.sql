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
        assertThat(new ProposedCombination(Color.get("")).getError(), is(Error.WRONG_LENGTH));
        assertThat(new ProposedCombination(Color.get("rg")).getError(), is(Error.WRONG_LENGTH));
        assertThat(new ProposedCombination(Color.get("rgbcy")).getError(), is(Error.WRONG_LENGTH));
        assertThat(new ProposedCombination(Color.get("rgasdvbnxcjkvbiasd24563")).getError(), is(Error.WRONG_LENGTH));
    }

    @Test
    public void testGivenProposedCombinationWhenGetErrorThenWrongCharactersError() {
        assertThat(new ProposedCombination(Color.get("rg5c")).getError(), is(Error.WRONG_CHARACTERS));
        assertThat(new ProposedCombination(Color.get("7362")).getError(), is(Error.WRONG_CHARACTERS));
        assertThat(new ProposedCombination(Color.get("ç{}+")).getError(), is(Error.WRONG_CHARACTERS));
    }

    @Test
    public void testGivenProposedCombinationWhenGetErrorThenDuplicatedError() {
        assertThat(new ProposedCombination(Color.get("bgbc")).getError(), is(Error.DUPLICATED));
        assertThat(new ProposedCombination(Color.get("bbbb")).getError(), is(Error.DUPLICATED));
        assertThat(new ProposedCombination(Color.get("cygc")).getError(), is(Error.DUPLICATED));
    }

    @Test
    public void testGivenProposedCombinationWhenGetErrorThenNullError() {
        assertThat(new ProposedCombination(Color.get("rgby")).getError(), is(Error.NULL));
    }

    @Test
    public void testGivenColorsInProposedCombinationWhenColorIsContainedByPositionOutOfSizeThenIsAssert() {
        Assertions.assertThrows(AssertionError.class,
                () -> new ProposedCombination(ProposedCombinationTest.COLOR).contains(ProposedCombinationTest.COLOR.get(0), 10));
    }

}
