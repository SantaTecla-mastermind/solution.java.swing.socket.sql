package usantatecla.mastermind.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import usantatecla.mastermind.models.Board;
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

    private Board board;
    private ProposedCombinationView proposedCombinationView;
    private Conversor conversor;

    @BeforeEach
    public void beforeEach() {
        this.board = new Board();
        this.proposedCombinationView = new ProposedCombinationView();
        this.conversor = new Conversor();
    }

    @Test
    void testGivenWrongWidthProposedCombinationWhenReadThenCorrectErrorIsCaptured() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString(any())).thenReturn("rg", "rgbyo", ProposedCombinationViewTest.INITIALS);
            this.proposedCombinationView.read(this.board);
            verify(this.console, times(2)).writeln("Wrong proposed combination length");
        }
    }

    @Test
    void testGivenWrongCharactersProposedCombinationWhenReadThenCorrectErrorIsCaptured() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString(any())).thenReturn("rqcp", "rpfi", "p^l0", ProposedCombinationViewTest.INITIALS);
            this.proposedCombinationView.read(this.board);
            verify(this.console, times(3)).writeln("Wrong colors, they must be: rgybmc");
        }
    }

    @Test
    void testGivenDuplicatedCharacterProposedCombinationWhenReadThenCorrectErrorIsCaptured() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString(any())).thenReturn("rmmg", "rrrr", "ygyg", ProposedCombinationViewTest.INITIALS);
            this.proposedCombinationView.read(this.board);
            verify(this.console, times(3)).writeln("Repeated colors");
        }
    }

    @Test
    void testGivenProposedCombinationWhenReadThenReturn() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString(any())).thenReturn(ProposedCombinationViewTest.INITIALS);
            assertThat(this.proposedCombinationView.read(this.board), is(Color.get(ProposedCombinationViewTest.INITIALS)));
        }
    }

    @Test
    void testGivenProposedCombinationWhenWriteThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString(any())).thenReturn(ProposedCombinationViewTest.INITIALS);
            this.proposedCombinationView.write(this.proposedCombinationView.read(this.board));
            ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
            verify(this.console, times(4)).write(argumentCaptor.capture());
            assertThat(this.conversor.arrayToString(argumentCaptor.getAllValues().toArray()),
                    is(this.conversor.toColorCodeString(ProposedCombinationViewTest.INITIALS)));
        }
    }

}
