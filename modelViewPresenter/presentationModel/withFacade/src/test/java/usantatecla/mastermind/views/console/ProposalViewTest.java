package usantatecla.mastermind.views.console;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.types.Error;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProposalViewTest {

    @Mock
    Console console;

    @Mock
    Logic logic;

    @InjectMocks
    ProposalView proposalView;

    @Test
    void testGiven1AttemptAndIsWinnerGameWhenInteractThenReturnsTrue() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.proposalView = new ProposalView(this.logic);
            when(this.console.readString(anyString())).thenReturn("rgby");
            when(this.logic.addProposedCombination(any())).thenReturn(Error.NULL);
            when(this.logic.isWinner()).thenReturn(true);

            assertThat(this.proposalView.interact(), is(true));
        }
    }

    @Test
    void testGiven1AttemptAndIsNotWinnerNorLooserGameWhenInteractThenReturnsFalse() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.proposalView = new ProposalView(this.logic);
            when(this.console.readString(anyString())).thenReturn("rgby");
            when(this.logic.addProposedCombination(any())).thenReturn(Error.NULL);
            when(this.logic.isWinner()).thenReturn(false);
            when(this.logic.isLooser()).thenReturn(false);

            assertThat(this.proposalView.interact(), is(false));
        }
    }

    @Test
    void testGivenSomeBadProposedCombinationWhenCorrectOneIsGivenThenInteractFinish() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.proposalView = new ProposalView(this.logic);
            when(this.console.readString(anyString()))
                    .thenReturn("rgbyo", "rgby");
            when(this.logic.addProposedCombination(any()))
                    .thenReturn(Error.WRONG_LENGTH, Error.NULL);
            when(this.logic.isWinner()).thenReturn(true);

            assertThat(this.proposalView.interact(), is(true));
            verify(this.console).writeln("Wrong proposed combination length");

        }
    }
}
