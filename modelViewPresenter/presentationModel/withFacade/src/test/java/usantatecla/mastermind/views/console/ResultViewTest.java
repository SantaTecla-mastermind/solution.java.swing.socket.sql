package usantatecla.mastermind.views.console;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.controllers.Logic;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ResultViewTest {
    @Mock
    Console console;

    @Mock
    Logic logic;

    @InjectMocks
    ResultView resultView;

    @Test
    void testGivenResultViewWhenWritelnThenCorrectMessageIsDisplayed() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.resultView = new ResultView(this.logic);
            ArgumentCaptor<String> resultCaptor = ArgumentCaptor.forClass(String.class);
            when(this.logic.getBlacks(anyInt())).thenReturn(2);
            when(this.logic.getWhites(anyInt())).thenReturn(1);

            this.resultView.writeln(0);

            verify(this.console).writeln(resultCaptor.capture());

            assertThat(resultCaptor.getValue(), is(" --> 2 blacks and 1 whites"));
        }
    }
}
