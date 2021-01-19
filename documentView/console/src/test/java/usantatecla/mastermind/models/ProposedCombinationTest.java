package usantatecla.mastermind.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.types.Error;
import usantatecla.utils.views.ColorCode;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
public class ProposedCombinationTest {

    private static final List<ColorCode> COLOR_CODES = Arrays.asList(
            ColorCode.GREEN,
            ColorCode.CYAN,
            ColorCode.RED,
            ColorCode.MAGENTA);
    private ProposedCombination proposedCombination;

    @BeforeEach
    void beforeEach() {
        this.proposedCombination = new ProposedCombination();
    }

    @Test
    void testGivenProposedCombinationWithColorCodesWhenGetColorCodesThenReturn() {
        for (ColorCode colorCode : ProposedCombinationTest.COLOR_CODES) {
            this.proposedCombination.add(colorCode);
        }
        assertThat(this.proposedCombination.getColorCodes(), is(ProposedCombinationTest.COLOR_CODES));
    }

    @Test
    void testGivenEmptyProposedCombinationWhenAddColorCodeThenContainsColorCode() {
        this.proposedCombination.add(ProposedCombinationTest.COLOR_CODES.get(0));
        assertThat(this.proposedCombination.contains(ProposedCombinationTest.COLOR_CODES.get(0), 0), is(true));
    }

    @Test
    void testGivenProposedCombinationWithColorCodesWhenResetThenNotContainAnyColor() {
        for (ColorCode colorCode : ProposedCombinationTest.COLOR_CODES) {
            this.proposedCombination.add(colorCode);
        }
        this.proposedCombination.reset();
        List<ColorCode> colorCodes = ColorFactory.getInstance().getAllColorCodes();
        for (ColorCode colorCode : colorCodes) {
            assertThat(this.proposedCombination.contains(colorCode), is(false));
        }
    }

    @Test
    void testGivenProposedCombinationWhenGetColorCodesErrorThenWrongLengthError() {
        assertThat(this.proposedCombination.getColorCodesError(""), is(Error.WRONG_LENGTH));
        assertThat(this.proposedCombination.getColorCodesError("rg"), is(Error.WRONG_LENGTH));
        assertThat(this.proposedCombination.getColorCodesError("rgbcy"), is(Error.WRONG_LENGTH));
        assertThat(this.proposedCombination.getColorCodesError("rgasdvbnxcjkvbiasd24563"), is(Error.WRONG_LENGTH));
    }

    @Test
    void testGivenProposedCombinationWhenGetColorCodesErrorThenWrongCharactersError() {
        assertThat(this.proposedCombination.getColorCodesError("rg5c"), is(Error.WRONG_CHARACTERS));
        assertThat(this.proposedCombination.getColorCodesError("7362"), is(Error.WRONG_CHARACTERS));
        assertThat(this.proposedCombination.getColorCodesError("ç{}+"), is(Error.WRONG_CHARACTERS));
    }

    @Test
    void testGivenProposedCombinationWhenGetColorCodesErrorThenDuplicatedError() {
        assertThat(this.proposedCombination.getColorCodesError("bgbc"), is(Error.DUPLICATED));
        assertThat(this.proposedCombination.getColorCodesError("bbbb"), is(Error.DUPLICATED));
        assertThat(this.proposedCombination.getColorCodesError("cygc"), is(Error.DUPLICATED));
    }

    @Test
    void testGivenProposedCombinationWhenGetColorCodesErrorThenNullError() {
        assertThat(this.proposedCombination.getColorCodesError("rgby"), is(Error.NULL));
        assertThat(this.proposedCombination.getColorCodesError("cgby"), is(Error.NULL));
    }

    @Test
    void testGivenColorsInProposedCombinationWhenColorIsContainedByPositionOutOfSizeThenIsAssert() {
        Assertions.assertThrows(AssertionError.class,
                () -> this.proposedCombination.contains(ProposedCombinationTest.COLOR_CODES.get(0), 10));
    }

}
