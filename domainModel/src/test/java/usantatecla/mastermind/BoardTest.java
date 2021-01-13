package usantatecla.mastermind;


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
        ColorCode[] colorCodes = {ColorCode.RED, ColorCode.GREEN, ColorCode.BLUE, ColorCode.YELLOW};
        String initials = getCombinationString(colorCodes);
        Board board = new BoardBuilder().proposedCombinations(initials).build();
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
        ColorCode[] colorCodes = {ColorCode.RED, ColorCode.GREEN, ColorCode.BLUE, ColorCode.YELLOW};
        String initials = getCombinationString(colorCodes);
        Board board = new BoardBuilder()
                .proposedCombinations(initials)
                .build(new Result(4,4));

        assertThat(board.isWinner(),is(true));
    }

    @Test
    public void testGivenBoardWhenIsWinnerThenFalse(){
        ColorCode[] colorCodes = {ColorCode.RED, ColorCode.GREEN, ColorCode.BLUE, ColorCode.YELLOW};
        String initials = getCombinationString(colorCodes);
        Board board = new BoardBuilder()
                .proposedCombinations(initials)
                .build(new Result(2,2));

        assertThat(board.isWinner(),is(false));
    }

    @Test
    public void testGivenBoardWhenIsFinishedThenTrue(){
        ColorCode[] colorCodes = {ColorCode.RED, ColorCode.GREEN, ColorCode.BLUE, ColorCode.YELLOW};
        String initials = getCombinationString(colorCodes);
        Board board = new BoardBuilder()
                .proposedCombinations(initials)
                .build(new Result(4,4));

        assertThat(board.isFinished(),is(true));
    }

    @Test
    public void testGivenBoardWhenIsFinishedThenFalse(){
        ColorCode[] colorCodes = {ColorCode.RED, ColorCode.GREEN, ColorCode.BLUE, ColorCode.YELLOW};
        String initials = getCombinationString(colorCodes);
        Board board = new BoardBuilder()
                .proposedCombinations(initials)
                .build(new Result(2,2));

        assertThat(board.isFinished(),is(false));
    }

    @Test
    public void testGivenBoardAndPut10TokensWhenIsFinishedThenTrue(){
        ColorCode[] colorCodes = {ColorCode.RED, ColorCode.GREEN, ColorCode.BLUE, ColorCode.YELLOW};
        String initials = getCombinationString(colorCodes);
        Board board = new BoardBuilder()
                .proposedCombinations(10,initials)
                .build();

        assertThat(board.isFinished(),is(true));
    }

    @Test
    public void testGivenBoardAndPut5TokensWhenIsFinishedThenTrue(){
        ColorCode[] colorCodes = {ColorCode.RED, ColorCode.GREEN, ColorCode.BLUE, ColorCode.YELLOW};
        String initials = getCombinationString(colorCodes);
        Board board = new BoardBuilder()
                .proposedCombinations(5,initials)
                .build();

        assertThat(board.isFinished(),is(false));
    }

    @Test
    public void testGivenBoardWhenWriteThenPrint() {
        ColorCode[] colorCodes = {ColorCode.RED, ColorCode.GREEN, ColorCode.BLUE, ColorCode.YELLOW};
        String initials = getCombinationString(colorCodes);
        Board board = new BoardBuilder().proposedCombinations(2, initials).build();
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
