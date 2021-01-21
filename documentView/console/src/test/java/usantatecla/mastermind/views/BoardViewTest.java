package usantatecla.mastermind.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.models.BoardBuilder;
import usantatecla.mastermind.models.Result;
import usantatecla.mastermind.types.Color;
import usantatecla.utils.views.ColorCode;
import usantatecla.utils.views.Console;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BoardViewTest {

    @Mock
    private Console console;

    private BoardView boardView;

    @BeforeEach
    public void beforeEach() {
        this.boardView = new BoardView();
    }

    @Test
    public void testGivenBoardViewWhenWriteWithEmptyBoardThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.boardView.write(new Board());
            String[] strings = {
                    "0 attempt(s): ",
                    "****"
            };
            for (String string : strings) {
                verify(this.console).writeln(string);
            }
        }
    }

    @Test
    public void testGivenBoardViewWhenWriteThenPrint() {//TODO AYUDA!
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.boardView.write(new BoardBuilder()
                    .proposedCombinations(3, "rgby")
                    .result(new Result(2, 2))
                    .build());
            String string = this.arrayToString(new String[]{
                    "3 attempt(s): ",
                    "****",
                    this.toColorCodeString("rgby") + " --> 2 blacks and 2 whites",
                    this.toColorCodeString("rgby") + " --> 2 blacks and 2 whites",
                    this.toColorCodeString("rgby") + " --> 2 blacks and 2 whites"
            });
            ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
            verify(this.console, atLeastOnce()).writeln(argumentCaptor.capture());
            verify(this.console, atLeastOnce()).write(argumentCaptor.capture());
            assertThat(string,is(arrayToString(argumentCaptor.getAllValues().toArray())));
        }
    }

    private String toColorCodeString(String initials) {
        List<ColorCode> colorCodes = new ProposedCombinationView().getColorCodes(Color.get(initials));
        String string = "";
        for (ColorCode colorCode : colorCodes) {
            string += colorCode.toString();
        }
        return string;
    }

    private String arrayToString(Object[] stringArray) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < stringArray.length; i++) {
            stringBuilder.append(stringArray[i]);
        }
        return stringBuilder.toString();
    }

}
