package usantatecla.mastermind.views;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.utils.Console;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProposedCombinationViewTest {
/*
    @Mock
    Console console;

    @Mock
    ProposedCombination proposedCombination;

    @InjectMocks
    ProposedCombinationView proposedCombinationView;

    @Test
    void testGivenWrongWidthProposedCombinationWhenReadThenCorrectErrorIsCaptured() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            when(this.console.readString()).thenReturn("rg", "rgbyo", "rgby");
            console.when(Console::getInstance).thenReturn(this.console);
            this.proposedCombinationView.read();
            verify(this.console, times(2)).writeln("Wrong proposed combination length");
        }
    }

    @Test
    void testGivenWrongCharacterProposedCombinationWhenReadThenCorrectErrorIsCaptured() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            when(this.console.readString()).thenReturn("rqop", "rpfi", "pñl0", "rgby");
            console.when(Console::getInstance).thenReturn(this.console);
            this.proposedCombinationView.read();
            verify(this.console, times(3)).writeln("Wrong colors, they must be: " + ColorView.allInitials());
        }
    }

    @Test
    void testGivenDuplicatedCharacterProposedCombinationWhenReadThenCorrectErrorIsCaptured() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            when(this.console.readString())
                    .thenReturn("roog")
                    .thenReturn("rrrr")
                    .thenReturn("ygyg")
                    .thenReturn("rgby");
            when(this.proposedCombination.getColors()).thenReturn(new ArrayList<>());
            console.when(Console::getInstance).thenReturn(this.console);
            this.proposedCombinationView.read();
            verify(this.console, times(3)).writeln("Repeated colors");
        }
    }
*/





    /*@Test
    void testGivenEmptyProposedCombinationWhenReadValidCombinationThenContainsColors() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            String colors = "rgby";
            when(this.console.readString()).thenReturn(colors);
            this.proposedCombination.read();
            List<ColorCode> colorCodes = ColorFactory.getInstance().getColorCodes(colors);
            for (int i = 0; i < colorCodes.size(); i++) {
                assertThat(this.proposedCombination.contains(colorCodes.get(i), i), is(true));
            }
        }
    }

    @Test
    void testGivenEmptyProposedCombinationWhenReadNotValidCombinationThenRequestCombination() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString()).thenReturn("rgbl", "rgby");
            this.proposedCombination.read();
            verify(this.console, times(2)).readString();
        }
    }

    @Test
    void testGivenEmptyProposedCombinationWhenReadNotValidSizeCombinationThenRequestCombination() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString()).thenReturn("rgbym", "rgby");
            this.proposedCombination.read();
            verify(this.console, times(2)).readString();
        }
    }

    @Test
    void testGivenEmptyProposedCombinationWhenReadRepeatCombinationThenRequestCombination() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString()).thenReturn("rbry", "rgby");
            this.proposedCombination.read();
            verify(this.console, times(2)).readString();
        }
    }*/

    /*@Test
    void testGivenColorsInProposedCombinationWhenColorIsContainedThenIsTrue() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            String colors = "rgby";
            when(this.console.readString()).thenReturn(colors);
            this.proposedCombination.read();
            for (ColorCode colorCode : ColorFactory.getInstance().getColorCodes(colors)) {
                assertThat(this.proposedCombination.contains(colorCode), is(true));
            }
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
    void testGivenProposedCombinationWhenWriteThenWriteColors() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            String colors = "rgby";
            when(this.console.readString()).thenReturn(colors);
            this.proposedCombination.read();
            this.proposedCombination.write();
            for (ColorCode colorCode : ColorFactory.getInstance().getColorCodes(colors)) {
                verify(this.console, times(1)).write(colorCode.get() + colorCode.getInitial() + ColorCode.RESET_COLOR.get());
            }
        }

    }*/
}
