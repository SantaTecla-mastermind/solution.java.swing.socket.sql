package usantatecla.mastermind;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.ColorCode;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

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
                .proposedCombinations(2, BoardTest.PROPOSED_COMBINATION)
                .build();
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            board.write();
            verify(this.console).writeln("2 attempt(s): ");
            verify(this.console).writeln(Message.SECRET_COMBINATION.toString());
            for (ColorCode colorCode : ColorFactory.getInstance().getColorCodes(BoardTest.PROPOSED_COMBINATION)) {
                verify(this.console, times(2)).write(colorCode.get() + colorCode.getInitial() + ColorCode.RESET_COLOR.get());
            }
        }
    }

}
