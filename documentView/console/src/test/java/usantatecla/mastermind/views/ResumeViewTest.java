package usantatecla.mastermind.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.models.Game;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ResumeViewTest {

    @Mock
    Game game;

    @Mock
    Console console;

    ResumeView resumeView;

    @BeforeEach
    void before() {
        resumeView = new ResumeView(game);
    }

    @Test
    void testGivenNewGameIsFalseWhenInteractThenIsFalse() {
        // TODO Descubrir como crear mocks de objetos que se crean al vuelo
        //when(this.yesNoDialog.read()).thenReturn(true);
        MockedStatic console = mockStatic(Console.class);
        console.when(Console::getInstance).thenReturn(this.console);

        when(this.console.readChar(anyString())).thenReturn('n');

        assertThat(this.resumeView.interact(), is(false));

    }

    @Test
    void testGivenNewGameIsTrueWhenInteractThenIsTrue() {
        MockedStatic console = mockStatic(Console.class);
        console.when(Console::getInstance).thenReturn(this.console);

        when(this.console.readChar(anyString())).thenReturn('y');

        assertThat(this.resumeView.interact(), is(true));

    }
}
