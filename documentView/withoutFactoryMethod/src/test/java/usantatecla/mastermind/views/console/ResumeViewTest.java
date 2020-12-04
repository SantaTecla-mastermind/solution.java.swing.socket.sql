package usantatecla.mastermind.views.console;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
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

    @InjectMocks
    ResumeView resumeView;

    @Test
    void testGivenNewGameIsFalseWhenInteractThenIsFalse() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            when(this.console.readChar(anyString())).thenReturn('n');
            console.when(Console::getInstance).thenReturn(this.console);
            assertThat(this.resumeView.interact(), is(false));
        }

    }

    @Test
    void testGivenNewGameIsTrueWhenInteractThenIsTrue() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            when(this.console.readChar(anyString())).thenReturn('y');
            console.when(Console::getInstance).thenReturn(this.console);
            assertThat(this.resumeView.interact(), is(true));
        }
    }
}