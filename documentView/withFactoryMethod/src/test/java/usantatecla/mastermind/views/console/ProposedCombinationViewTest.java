package usantatecla.mastermind.views.console;

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
            verify(this.console, times(3)).writeln("Wrong colors, they must be: " + new ColorView().allInitials());
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
}
