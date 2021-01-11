package usantatecla.mastermind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.ColorCode;
import usantatecla.utils.Console;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProposedCombinationTest {

    private ProposedCombination proposedCombination;

    @Mock
    Console console;

    @BeforeEach
    void beforeEach() {
        this.proposedCombination = new ProposedCombination();
    }

    @Test
    void testGivenEmptyProposedCombinationWhenReadValidCombinationThenContainsColors(){
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString()).thenReturn("rgby");
            this.proposedCombination.read();
            ColorCode[] colorCodes = {ColorCode.RED,ColorCode.GREEN,ColorCode.BLUE,ColorCode.YELLOW};
            for(int i=0;i<colorCodes.length;i++){
                assertThat(this.proposedCombination.contains(colorCodes[i],i),is(true));
            }
        }
    }

    @Test
    void testGivenEmptyProposedCombinationWhenReadNotValidCombinationThenRequestCombination(){
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString()).thenReturn("rgbl","rgby");
            this.proposedCombination.read();
            verify(this.console,times(2)).readString();
        }
    }

    @Test
    void testGivenEmptyProposedCombinationWhenReadNotValidSizeCombinationThenRequestCombination(){
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString()).thenReturn("rgbym","rgby");
            this.proposedCombination.read();
            verify(this.console,times(2)).readString();
        }
    }

    @Test
    void testGivenEmptyProposedCombinationWhenReadRepeatCombinationThenRequestCombination(){
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString()).thenReturn("rbry","rgby");
            this.proposedCombination.read();
            verify(this.console,times(2)).readString();
        }
    }

    //TODO con un for
    @Test
    void testGivenEmptyProposedCombinationWhenGetColorsLengthThenReturns0() {
        assertThat(this.proposedCombination.colorCodes.size(), is(0));
    }

    @Test
    void testGivenColorsInProposedCombinationWhenColorIsNotContainedThenIsFalse() {
        this.proposedCombination.colorCodes = new ArrayList<>(Arrays.asList(ColorCode.RED,ColorCode.GREEN,ColorCode.YELLOW,ColorCode.CYAN));
        assertThat(this.proposedCombination.contains(ColorCode.MAGENTA), is(false));
    }

    @Test
    void testGivenColorsInProposedCombinationWhenColorIsContainedThenIsTrue() {
        this.proposedCombination.colorCodes = new ArrayList<>(Arrays.asList(ColorCode.RED,ColorCode.GREEN,ColorCode.YELLOW,ColorCode.CYAN));
        assertThat(this.proposedCombination.contains(ColorCode.RED), is(true));
    }

    @Test
    void testGivenColorsInProposedCombinationWhenColorIsContainedByPositionOutOfSizeThenIsAssert() {
        this.proposedCombination.colorCodes = new ArrayList<>(Arrays.asList(ColorCode.RED,ColorCode.GREEN,ColorCode.YELLOW,ColorCode.CYAN));
        Assertions.assertThrows(AssertionError.class, () -> this.proposedCombination.contains(ColorCode.RED,10));
    }
}
