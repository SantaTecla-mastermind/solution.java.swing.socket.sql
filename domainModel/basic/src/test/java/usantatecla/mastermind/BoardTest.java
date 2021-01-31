package usantatecla.mastermind;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.ColorCode;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class BoardTest {

    private static final String PROPOSED_COMBINATION = "rgby";

    private BoardBuilder boardBuilder;

    @Mock
    private Console console;

    @BeforeEach
    public void beforeEach() {
        this.boardBuilder = new BoardBuilder();
    }

    @Test
    public void testGivenBoardWhenResetThenEmpty() {
        Board board = this.boardBuilder
                .proposedCombinations(3, BoardTest.PROPOSED_COMBINATION)
                .build();
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            board.reset();
            board.write();
            verify(this.console).writeln("0 attempt(s): ");
        }
    }

    @Test
    public void testGivenBoardWhenAddThenCorrect() {
        Board board = this.boardBuilder
                .proposedCombinations(BoardTest.PROPOSED_COMBINATION)
                .build();
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            board.write();
            for (ColorCode colorCode : ColorFactory.getInstance().getColorCodes(BoardTest.PROPOSED_COMBINATION)) {
                verify(this.console).write(colorCode.get() + colorCode.getInitial() + ColorCode.RESET_COLOR.get());
            }
        }
    }

    @Test
    public void testGivenBoardWhenIsFinishedThenTrue() {
        Board board = this.boardBuilder
                .proposedCombinations(BoardTest.PROPOSED_COMBINATION)
                .blacks(Result.WIDTH)
                .whites(0)
                .build();
        assertThat(board.isFinished(), is(true));
    }

    @Test
    public void testGivenBoardWhenIsFinishedThenFalse() {
        Board board = this.boardBuilder
                .proposedCombinations(BoardTest.PROPOSED_COMBINATION)
                .blacks(Result.WIDTH - 1)
                .whites(0)
                .build();
        assertThat(board.isFinished(), is(false));
    }

    @Test
    public void testGivenBoardAndPut10TokensWhenIsFinishedThenTrue() {
        Board board = this.boardBuilder
                .proposedCombinations(Board.MAX_ATTEMPTS, BoardTest.PROPOSED_COMBINATION)
                .build();
        assertThat(board.isFinished(), is(true));
    }

    @Test
    public void testGivenBoardWhenIsWinnerThenTrue() {
        Board board = this.boardBuilder
                .proposedCombinations(BoardTest.PROPOSED_COMBINATION)
                .blacks(Result.WIDTH)
                .whites(0)
                .build();
        assertThat(board.isWinner(), is(true));
    }

    @Test
    public void testGivenBoardWhenIsWinnerThenFalse() {
        Board board = this.boardBuilder
                .proposedCombinations(BoardTest.PROPOSED_COMBINATION)
                .blacks(Result.WIDTH - 1)
                .whites(0)
                .build();
        assertThat(board.isWinner(), is(false));
    }

    @Test
    public void testGivenBoardWhenWriteThenPrint() {
        Board board = this.boardBuilder
                .proposedCombinations(3, BoardTest.PROPOSED_COMBINATION)
                .blacks(2).whites(2)
                .build();
        String string = this.arrayToString(new String[]{
            "3 attempt(s): ",
            "****",
            this.toColorCodeString("rgby") + " --> 2 blacks and 2 whites",
            this.toColorCodeString("rgby") + " --> 2 blacks and 2 whites",
            this.toColorCodeString("rgby") + " --> 2 blacks and 2 whites"
        });
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            board.write();
            ArgumentCaptor<String> argumentCaptor = ArgumentCaptor.forClass(String.class);
            verify(this.console, atLeastOnce()).writeln(argumentCaptor.capture());
            verify(this.console, atLeastOnce()).write(argumentCaptor.capture());
            assertThat(string, is(this.reorder(argumentCaptor.getAllValues())));
        }
    }

    private String arrayToString(Object[] objects) {
        String string = "";
        for (Object object : objects) {
            string += object;
        }
        return string;
    }

    private String toColorCodeString(String initials) {
        List<ColorCode> colorCodes = ColorFactory.getInstance().getColorCodes(initials);
        String string = "";
        for (ColorCode colorCode : colorCodes) {
            string += colorCode.toString();
        }
        return string;
    }

    private String reorder(List<String> strings) {
        int proposedCombinationStartIndex = 2;
        int attempts = 3;
        int proposedCombinationWidth = 4;

        for (int i = proposedCombinationStartIndex; i < proposedCombinationStartIndex + attempts; i++) {
            String proposedCombination = "";
            for (int j = proposedCombinationWidth; j > 0; j--) {
                proposedCombination += strings.remove(strings.size() - j);
            }
            strings.set(i, proposedCombination + strings.get(i));
        }
        return this.arrayToString(strings.toArray());
    }

}
