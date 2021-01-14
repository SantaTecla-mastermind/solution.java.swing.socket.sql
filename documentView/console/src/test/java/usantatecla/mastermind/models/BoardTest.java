package usantatecla.mastermind.models;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.ColorCode;
import usantatecla.utils.Console;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import static org.mockito.Mockito.*;

public class BoardTest {

    @Test
    public void testGivenBoardWhenAddThenCorrect() {
        String colors = "rgby";
        Board board = new BoardBuilder().proposedCombinations(colors).build();
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            board.write();
            for (ColorCode colorCode : ColorFactory.getInstance().getColorCodes(colors)) {
                verify(this.console).write(colorCode.get() + colorCode.getInitial() + ColorCode.RESET_COLOR.get());
            }
        }
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
        BoardBuilder boardBuilder = new BoardBuilder();
        for(int i=0;i<10;i++){
            boardBuilder.proposedCombinations("rgby");
        }
        Board board = boardBuilder.build();

        assertThat(board.isFinished(),is(true));
    }

    @Test
    public void testGivenBoardAndPut5TokensWhenIsFinishedThenTrue(){
        Board board = new BoardBuilder()
                .proposedCombinations(5,"rgby")
                .build();

        assertThat(board.isFinished(),is(false));
    }

}
