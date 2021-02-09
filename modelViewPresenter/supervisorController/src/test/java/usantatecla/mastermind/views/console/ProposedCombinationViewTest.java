package usantatecla.mastermind.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.mastermind.types.Color;
import usantatecla.utils.views.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProposedCombinationViewTest {

    private static final String INITIALS = "rgby";

    @Mock
    private Console console;

    private ProposedCombinationView proposedCombinationView;
    private Conversor conversor;

    @BeforeEach
    public void beforeEach() {
        this.conversor = new Conversor();
    }

    @Test
    void testGivenProposedCombinationWhenReadThenReturn() {
        this.proposedCombinationView = new ProposedCombinationView();
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString(any())).thenReturn(ProposedCombinationViewTest.INITIALS);
            assertThat(this.proposedCombinationView.read().getColors(), is(Color.get(ProposedCombinationViewTest.INITIALS)));
        }
    }

    @Test
    void testGivenProposedCombinationWhenWriteThenPrint() {
        this.proposedCombinationView = new ProposedCombinationView(new ProposedCombination(Color.get(INITIALS)));

        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.proposedCombinationView.write();
            ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
            verify(this.console, times(4)).write(argumentCaptor.capture());
            assertThat(this.conversor.arrayToString(argumentCaptor.getAllValues().toArray()),
                    is(this.conversor.toColorCodeString(ProposedCombinationViewTest.INITIALS)));
        }
    }

}
