package usantatecla.mastermind.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;
import usantatecla.mastermind.models.Game;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;
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
        // TODO Descubrir como crear mocks de objetos que se crean al vuelo
        //when(this.yesNoDialog.read()).thenReturn(true);

        when(this.console.readChar(anyString())).thenReturn('n');
        try (MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);

            assertThat(this.resumeView.interact(), is(false));
        }
    }

    @Test
    void testGivenNewGameIsTrueWhenInteractThenIsTrue() {
        when(this.console.readChar(anyString())).thenReturn('y');
        try (MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);

            assertThat(this.resumeView.interact(), is(true));
        }
    }
}
