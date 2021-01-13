package usantatecla.mastermind;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.ColorCode;
import usantatecla.utils.Console;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BoardTest {

    @Mock
    Console console;

    @Test
    public void testGivenBoardWhenResetThenEmpty() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            Board board = new BoardBuilder().build();
            board.reset();
            board.write();
            verify(this.console).writeln("0 attempt(s): ");
        }
    }

    @Test
    public void testGivenBoardWhenAddThenCorrect() {
        List<ColorCode> colorCodes = ColorFactory.getInstance().getColors("rgby");
        Board board = new BoardBuilder().proposedCombinations("rgby").build();
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            board.write();
            for (ColorCode colorCode : colorCodes) {
                verify(this.console).write(colorCode.getColor() + colorCode.getInitial() + ColorCode.RESET_COLOR.getColor());
            }
        }
    }

    private String getCombinationString(ColorCode[] colorCodes) {
        String initials = "";
        for (ColorCode colorCode : colorCodes) {
            initials += colorCode.getInitial();
        }
        return initials;
    }

    @Test
    public void testGivenBoardWhenIsWinnerThenTrue(){
        Board board = new BoardBuilder()
                .proposedCombinations("rgby")
                .result(new Result(4,4))
                .build();

        assertThat(board.isWinner(),is(true));
    }

    @Test
    public void testGivenBoardWhenIsWinnerThenFalse(){
        Board board = new BoardBuilder()
                .proposedCombinations("rgby")
                .result(new Result(2,2))
                .build();

        assertThat(board.isWinner(),is(false));
    }

    @Test
    public void testGivenBoardWhenIsFinishedThenTrue(){
        Board board = new BoardBuilder()
                .proposedCombinations("rgby")
                .result(new Result(4,4))
                .build();

        assertThat(board.isFinished(),is(true));
    }

    @Test
    public void testGivenBoardWhenIsFinishedThenFalse(){
        Board board = new BoardBuilder()
                .proposedCombinations("rgby")
                .result(new Result(2,2))
                .build();

        assertThat(board.isFinished(),is(false));
    }

    @Test
    public void testGivenBoardAndPut10TokensWhenIsFinishedThenTrue(){
        Board board = new BoardBuilder()
                .proposedCombinations(10,"rgby")
                .build();

        assertThat(board.isFinished(),is(true));
    }

    @Test
    public void testGivenBoardAndPut5TokensWhenIsFinishedThenTrue(){
        Board board = new BoardBuilder()
                .proposedCombinations(5,"rgby")
                .build();

        assertThat(board.isFinished(),is(false));
    }

    @Test
    public void testGivenBoardWhenWriteThenPrint() {
        List<ColorCode> colorCodes = ColorFactory.getInstance().getColors("rgby");
        Board board = new BoardBuilder().proposedCombinations(2, "rgby").build();
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            board.write();
            for (ColorCode colorCode : colorCodes) {
                verify(this.console).writeln("2 attempt(s): ");
                verify(this.console).writeln("****");
                verify(this.console, times(2)).write(colorCode.getColor() + colorCode.getInitial() + ColorCode.RESET_COLOR.getColor());
            }
        }
    }

}
