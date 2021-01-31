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

    private static final String INITIALS = "rgby";

    private ProposedCombination proposedCombination;

    @Mock
    private Console console;

    @BeforeEach
    public void beforeEach() {
        this.proposedCombination = new ProposedCombination();
    }

    @Test
    public void testGivenEmptyProposedCombinationWhenReadNotValidCombinationThenRequestCombination() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString()).thenReturn("rgbl", ProposedCombinationTest.INITIALS);
            this.proposedCombination.read();
            verify(this.console, times(2)).readString();
        }
    }

    @Test
    public void testGivenEmptyProposedCombinationWhenReadNotValidSizeCombinationThenRequestCombination() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString()).thenReturn("rgbym", ProposedCombinationTest.INITIALS);
            this.proposedCombination.read();
            verify(this.console, times(2)).readString();
        }
    }

    @Test
    public void testGivenEmptyProposedCombinationWhenReadRepeatCombinationThenRequestCombination() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString()).thenReturn("rbry", ProposedCombinationTest.INITIALS);
            this.proposedCombination.read();
            verify(this.console, times(2)).readString();
        }
    }

    @Test
    public void testGivenEmptyProposedCombinationWhenReadValidCombinationThenContainsColors() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString()).thenReturn(ProposedCombinationTest.INITIALS);
            this.proposedCombination.read();
            List<ColorCode> colorCodes = ColorFactory.getInstance().getColorCodes(ProposedCombinationTest.INITIALS);
            for (int i = 0; i < colorCodes.size(); i++) {
                assertThat(this.proposedCombination.contains(colorCodes.get(i), i), is(true));
            }
        }
    }

    @Test
    public void testGivenColorsInProposedCombinationWhenColorIsContainedByPositionOutOfSizeThenIsAssert() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString()).thenReturn(ProposedCombinationTest.INITIALS);
            this.proposedCombination.read();
            Assertions.assertThrows(AssertionError.class, () -> this.proposedCombination.contains(ColorCode.RED, 10));
        }
    }

    @Test
    public void testGivenEmptyProposedCombinationThenNotContainAnyColor() {
        List<ColorCode> colorCodes = ColorFactory.getInstance().getAllColorCodes();
        for (ColorCode colorCode : colorCodes) {
            assertThat(this.proposedCombination.contains(colorCode), is(false));
        }
    }

    @Test
    public void testGivenColorsInProposedCombinationWhenColorIsContainedThenIsTrue() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString()).thenReturn(ProposedCombinationTest.INITIALS);
            this.proposedCombination.read();
            for (ColorCode colorCode : ColorFactory.getInstance().getColorCodes(ProposedCombinationTest.INITIALS)) {
                assertThat(this.proposedCombination.contains(colorCode), is(true));
            }
        }
    }

    @Test
    public void testGivenProposedCombinationWhenWriteThenWriteColors() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString()).thenReturn(ProposedCombinationTest.INITIALS);
            this.proposedCombination.read();
            this.proposedCombination.write();
            for (ColorCode colorCode : ColorFactory.getInstance().getColorCodes(ProposedCombinationTest.INITIALS)) {
                verify(this.console, times(1)).write(colorCode.toString());
            }
        }
    }

}
