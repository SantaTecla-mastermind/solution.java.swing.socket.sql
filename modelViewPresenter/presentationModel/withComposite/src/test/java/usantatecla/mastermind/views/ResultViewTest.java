package usantatecla.mastermind.views;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.controllers.PlayController;

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
    PlayController playController;

    @InjectMocks
    ResultView resultView;

    @Test
    void testGivenResultViewWhenWritelnThenCorrectMessageIsDisplayed() {
        try(MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.resultView=new ResultView(this.playController);
            ArgumentCaptor<String> resultCaptor = ArgumentCaptor.forClass(String.class);
            when(this.playController.getBlacks(anyInt())).thenReturn(2);
            when(this.playController.getWhites(anyInt())).thenReturn(1);
            this.resultView.writeln(0);
            verify(this.console).writeln(resultCaptor.capture());
            assertThat(resultCaptor.getValue(), is(" --> 2 blacks and 1 whites"));
        }
    }
}
