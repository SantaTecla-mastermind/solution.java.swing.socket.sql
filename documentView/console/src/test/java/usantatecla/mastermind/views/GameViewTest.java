package usantatecla.mastermind.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.models.Game;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GameViewTest {

    @Mock
    Game game;

    @InjectMocks
    GameView gameView = new GameView(this.game);

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
}
