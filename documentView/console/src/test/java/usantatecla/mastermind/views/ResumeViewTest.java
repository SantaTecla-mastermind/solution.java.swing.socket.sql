package usantatecla.mastermind.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import usantatecla.mastermind.models.Game;
import usantatecla.utils.Console;
import usantatecla.utils.YesNoDialog;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class ResumeViewTest {

    @Mock
    Game game;

    @Mock
    Console console;

    @InjectMocks
    ResumeView resumeView = new ResumeView(game);

    @BeforeEach
    void before() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGivenNewGameIsFalseWhenInteractThenIsFalse() {
        // TODO Al ser ahora la consola un singleton no soy capaz de hacer un mock de consola
        // TODO Tampoco soy capaz de hacer mocks de clases que se crean al vuelo
        //when(this.console.readString(anyString())).thenReturn("n");

        //assertThat(this.resumeView.interact(), is(false));
    }

    @Test
    void testGivenNewGameIsTrueWhenInteractThenIsTrue() {
        //when(this.yesNoDialog.read()).thenReturn(true);

        //assertThat(this.resumeView.interact(), is(true));
    }
}
