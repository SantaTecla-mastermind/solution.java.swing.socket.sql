package console;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.types.Error;
import usantatecla.mastermind.views.Message;
import usantatecla.mastermind.views.console.ProposalView;
import usantatecla.utils.Console;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProposalViewTest {

    @Mock
    Console console;

    @Mock
    ProposalController proposalController;

    @InjectMocks
    ProposalView proposalView;

    @Test
    void testGiven1AttemptAndIsWinnerGame() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.proposalView = new ProposalView();
            when(this.console.readString(anyString())).thenReturn("rgby");
            when(this.proposalController.addProposedCombination(any())).thenReturn(Error.NULL);
            when(this.proposalController.isWinner()).thenReturn(true);
            this.proposalView.interact(this.proposalController);
            verify(this.console, times(2)).writeln();
            verify(this.console).writeln(Message.WINNER.getMessage());
        }
    }

    @Test
    void testGiven1AttemptAndIsLooserGame() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.proposalView = new ProposalView();
            when(this.console.readString(anyString())).thenReturn("rgby");
            when(this.proposalController.addProposedCombination(any())).thenReturn(Error.NULL);
            when(this.proposalController.isWinner()).thenReturn(false);
            when(this.proposalController.isLooser()).thenReturn(true);
            this.proposalView.interact(this.proposalController);
            verify(this.console, times(2)).writeln();
            verify(this.console).writeln(Message.LOOSER.getMessage());
        }
    }

    @Test
    void testGiven1AttemptAndIsNotWinnerNorLooserGameWhenInteractThenReturnsFalse() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.proposalView = new ProposalView();
            when(this.console.readString(anyString())).thenReturn("rgby");
            when(this.proposalController.addProposedCombination(any())).thenReturn(Error.NULL);
            when(this.proposalController.isWinner()).thenReturn(false);
            when(this.proposalController.isLooser()).thenReturn(false);
            this.proposalView.interact(this.proposalController);
            verify(this.console, times(2)).writeln();
        }
    }

    @Test
    void testGivenSomeBadProposedCombinationWhenCorrectOneIsGivenThenInteractFinish() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.proposalView = new ProposalView();
            when(this.console.readString(anyString()))
                    .thenReturn("rgbyo", "rgby");
            when(this.proposalController.addProposedCombination(any()))
                    .thenReturn(Error.WRONG_LENGTH, Error.NULL);
            when(this.proposalController.isWinner()).thenReturn(true);
            this.proposalView.interact(this.proposalController);
            verify(this.console, times(2)).readString("Propose a combination: ");

        }
    }
}
