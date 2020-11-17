package usantatecla.mastermind.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.models.Game;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GameViewTest {

    @Mock
    Game game;

    @Mock
    Console console;

    GameView gameView;

    @BeforeEach
    void before() {
        this.gameView = new GameView(this.game);
    }

    @Test
    void testGivenWinGameWhenIsWinnerOrLooserThenReturnsTrue() {
        when(this.game.isWinner()).thenReturn(true);
        assertThat(this.gameView.isWinnerOrLooser(), is(true));
    }

    @Test
    void testGivenLooseGameWhenIsWinnerOrLooserThenReturnsTrue() {
        when(this.game.isWinner()).thenReturn(false);
        when(this.game.isLooser()).thenReturn(true);
        assertThat(this.gameView.isWinnerOrLooser(), is(true));
    }

    @Test
    void testGivenNotLooseNorWinGameWhenIsWinnerOrLooserThenReturnsFalse() {
        when(this.game.isWinner()).thenReturn(false);
        when(this.game.isLooser()).thenReturn(false);
        assertThat(this.gameView.isWinnerOrLooser(), is(false));
    }

    @Test
    void testGivenEmptyGameStateWhenWriteThenOnlySecretCombinationIsWritten() {
        ArgumentCaptor<String> secretCombination = ArgumentCaptor.forClass(String.class);
        try(MockedStatic console = mockStatic(Console.class)){
            console.when(Console::getInstance).thenReturn(this.console);
            this.gameView.write();
            verify(this.console, times(2)).writeln();
            verify(this.console).write(secretCombination.capture());

            assertThat(secretCombination.getValue(), is("****"));
        }
    }

    @Test
    void testGiven2AttemptsGameStateWhenWriteThenCorrectArgumentsAreCaptured() {

    }
}
