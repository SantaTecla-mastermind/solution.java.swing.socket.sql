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
import java.util.List;

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

    @Test
    void testGivenEmptyProposedCombinationThenNotContainAnyColor() {
            List<ColorCode> colorCodes = ColorFactory.getInstance().getAllColorCodes();
            for(ColorCode colorCode : colorCodes){
                assertThat(this.proposedCombination.contains(colorCode),is(false));
            }
    }

    @Test
    void testGivenColorsInProposedCombinationWhenColorIsContainedThenIsTrue() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString()).thenReturn("rgby");
            this.proposedCombination.read();
            assertThat(this.proposedCombination.contains(ColorCode.RED), is(true));
            assertThat(this.proposedCombination.contains(ColorCode.GREEN), is(true));
            assertThat(this.proposedCombination.contains(ColorCode.BLUE), is(true));
            assertThat(this.proposedCombination.contains(ColorCode.YELLOW), is(true));
            }
        }

    @Test
    void testGivenColorsInProposedCombinationWhenColorIsContainedByPositionOutOfSizeThenIsAssert() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString()).thenReturn("rgby");
            this.proposedCombination.read();
            Assertions.assertThrows(AssertionError.class, () -> this.proposedCombination.contains(ColorCode.RED, 10));
        }
    }

    @Test
    void testGivenProposedCombinationWhenWriteThenWriteColors(){
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString()).thenReturn("rgby");
            this.proposedCombination.read();
            this.proposedCombination.write();
            verify(this.console, times(1)).write(ColorCode.RED.get()+"r"+ColorCode.RESET_COLOR.get());
            verify(this.console, times(1)).write(ColorCode.GREEN.get()+"g"+ColorCode.RESET_COLOR.get());
            verify(this.console, times(1)).write(ColorCode.BLUE.get()+"b"+ColorCode.RESET_COLOR.get());
            verify(this.console, times(1)).write(ColorCode.YELLOW.get()+"y"+ColorCode.RESET_COLOR.get());
        }
    }

}
