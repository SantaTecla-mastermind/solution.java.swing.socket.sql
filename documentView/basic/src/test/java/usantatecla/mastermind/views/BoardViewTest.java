package usantatecla.mastermind.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.models.BoardBuilder;
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
    private ViewTestUtils viewTestUtils;

    @BeforeEach
    public void beforeEach() {
        this.boardView = new BoardView();
        this.viewTestUtils = new ViewTestUtils();
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
    public void testGivenBoardViewWhenWriteThenPrint() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.boardView.write(new BoardBuilder()
                    .proposedCombinations(3, "rgby")
                    .blacks(2).whites(2)
                    .build());
            String string = this.viewTestUtils.arrayToString(new String[]{
                    "3 attempt(s): ",
                    "****",
                    this.viewTestUtils.toColorCodeString("rgby") + " --> 2 blacks and 2 whites",
                    this.viewTestUtils.toColorCodeString("rgby") + " --> 2 blacks and 2 whites",
                    this.viewTestUtils.toColorCodeString("rgby") + " --> 2 blacks and 2 whites"
            });
            ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
            verify(this.console, atLeastOnce()).writeln(argumentCaptor.capture());
            verify(this.console, atLeastOnce()).write(argumentCaptor.capture());

            assertThat(string, is(this.reOrder(argumentCaptor.getAllValues())));
        }
    }

    private String reOrder(List<String> strings) {
        int proposedCombinationStartIndex = 2;
        int attempts = 3;
        int proposedCombinationWidth = 4;

        for (int i = proposedCombinationStartIndex; i < proposedCombinationStartIndex + attempts; i++) {
            String proposedCombination = "";
            for(int j = proposedCombinationWidth; j > 0; j--) {
                proposedCombination += strings.remove(strings.size() - j);
            }
            strings.set(i, proposedCombination + strings.get(i));
        }
        return this.viewTestUtils.arrayToString(strings.toArray());
    }

}