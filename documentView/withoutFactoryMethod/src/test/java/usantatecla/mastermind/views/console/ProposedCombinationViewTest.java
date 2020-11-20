package usantatecla.mastermind.views.console;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProposedCombinationViewTest {

    @Mock
    Console console;

    ProposedCombinationView proposedCombinationView = new ProposedCombinationView(new ProposedCombination());

    @Test
    void testGivenWrongWidthProposedCombinationWhenReadThenCorrectErrorIsCaptured() {
        try(MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString())
                    .thenReturn("rg")
                    .thenReturn("rgbyo")
                    .thenReturn("rgby");
            ArgumentCaptor<String> captured = ArgumentCaptor.forClass(String.class);
            this.proposedCombinationView.read();

            verify(this.console, times(2)).writeln(captured.capture());

            String lengthError = "Wrong proposed combination length";
            assertThat(captured.getAllValues().get(0), is(lengthError));
            assertThat(captured.getAllValues().get(1), is(lengthError));
        }
    }

    @Test
    void testGivenWrongCharacterProposedCombinationWhenReadThenCorrectErrorIsCaptured() {
        try(MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString())
                    .thenReturn("rqop")
                    .thenReturn("rpfi")
                    .thenReturn("pñl0")
                    .thenReturn("rgby");
            ArgumentCaptor<String> captured = ArgumentCaptor.forClass(String.class);
            this.proposedCombinationView.read();

            verify(this.console, times(3)).writeln(captured.capture());

            String wrongCharError = "Wrong colors, they must be: " + new ColorView().allInitials();
            assertThat(captured.getAllValues().get(0), is(wrongCharError));
            assertThat(captured.getAllValues().get(1), is(wrongCharError));
            assertThat(captured.getAllValues().get(2), is(wrongCharError));
        }
    }

    @Test
    void testGivenDuplicatedCharacterProposedCombinationWhenReadThenCorrectErrorIsCaptured() {
        try(MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString())
                    .thenReturn("roog")
                    .thenReturn("rrrr")
                    .thenReturn("ygyg")
                    .thenReturn("rgby");
            ArgumentCaptor<String> captured = ArgumentCaptor.forClass(String.class);
            this.proposedCombinationView.read();

            verify(this.console, times(3)).writeln(captured.capture());

            String dupError = "Repeated colors";
            assertThat(captured.getAllValues().get(0), is(dupError));
            assertThat(captured.getAllValues().get(1), is(dupError));
            assertThat(captured.getAllValues().get(2), is(dupError));
        }
    }
}
