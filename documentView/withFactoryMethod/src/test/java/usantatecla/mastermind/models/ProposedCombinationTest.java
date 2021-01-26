package usantatecla.mastermind.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
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

    private ProposedCombination proposedCombination;

    @BeforeEach
    public void beforeEach() {
        this.proposedCombination = new ProposedCombination();
    }

    @Test
    public void testGivenProposedCombinationWithColorsWhenGetColorsThenReturn() {
        this.proposedCombination.add(ProposedCombinationTest.COLOR);
        assertThat(this.proposedCombination.getColors(), is(ProposedCombinationTest.COLOR));
    }

    @Test
    public void testGivenProposedCombinationWhenAddThenWrongLengthError() {
        assertThat(this.proposedCombination.add(Color.get("")), is(Error.WRONG_LENGTH));
        assertThat(this.proposedCombination.add(Color.get("rg")), is(Error.WRONG_LENGTH));
        assertThat(this.proposedCombination.add(Color.get("rgbcy")), is(Error.WRONG_LENGTH));
        assertThat(this.proposedCombination.add(Color.get("rgasdvbnxcjkvbiasd24563")), is(Error.WRONG_LENGTH));
    }

    @Test
    public void testGivenProposedCombinationWhenAddThenWrongCharactersError() {
        assertThat(this.proposedCombination.add(Color.get("rg5c")), is(Error.WRONG_CHARACTERS));
        assertThat(this.proposedCombination.add(Color.get("7362")), is(Error.WRONG_CHARACTERS));
        assertThat(this.proposedCombination.add(Color.get("ç{}+")), is(Error.WRONG_CHARACTERS));
    }

    @Test
    public void testGivenProposedCombinationWhenAddThenDuplicatedError() {
        assertThat(this.proposedCombination.add(Color.get("bgbc")), is(Error.DUPLICATED));
        assertThat(this.proposedCombination.add(Color.get("bbbb")), is(Error.DUPLICATED));
        assertThat(this.proposedCombination.add(Color.get("cygc")), is(Error.DUPLICATED));
    }

    @Test
    public void testGivenProposedCombinationWhenAddThenNullError() {
        assertThat(this.proposedCombination.add(Color.get("rgby")), is(Error.NULL));
    }

    @Test
    public void testGivenColorsInProposedCombinationWhenColorIsContainedByPositionOutOfSizeThenIsAssert() {
        Assertions.assertThrows(AssertionError.class,
                () -> this.proposedCombination.contains(ProposedCombinationTest.COLOR.get(0), 10));
    }

}
