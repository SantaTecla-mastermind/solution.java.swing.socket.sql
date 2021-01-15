package usantatecla.mastermind.views;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mockStatic;

@ExtendWith(MockitoExtension.class)
public class PlayViewTest {
/*
    @Mock
    Game game;

    @Mock
    Console console;

    @Mock
    ProposedCombination proposedCombination;

    @Mock
    Result result;

    @InjectMocks
    PlayView playView;

    @BeforeEach
    void before() {
        when(this.console.readString()).thenReturn("rgby");
        when(this.proposedCombination.getColors()).thenReturn(Arrays.asList(Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW));
        when(this.game.getAttempts()).thenReturn(1);
        when(this.game.getProposedCombination(anyInt())).thenReturn(this.proposedCombination);
        when(this.game.getResult(anyInt())).thenReturn(this.result);
        when(this.result.getBlacks()).thenReturn(2);
        when(this.result.getWhites()).thenReturn(2);
    }

    @Test
    void testGiven1AttemptAndIsWinnerGameWhenInteractThenReturnsTrue() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            when(this.game.isWinner()).thenReturn(true);
            console.when(Console::getInstance).thenReturn(this.console);
            assertThat(this.playView.interact(), is(true));
        }
    }

    @Test
    void testGiven1AttemptAndIsNotWinnerNorLooserGameWhenInteractThenReturnsFalse() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            when(this.game.isWinner()).thenReturn(false);
            when(this.game.isLooser()).thenReturn(false);
            console.when(Console::getInstance).thenReturn(this.console);
            assertThat(this.playView.interact(), is(false));
        }
    }
    */
}
