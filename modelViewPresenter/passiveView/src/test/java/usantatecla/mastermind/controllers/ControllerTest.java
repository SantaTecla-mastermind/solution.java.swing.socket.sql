package usantatecla.mastermind.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.ViewFactory;
import usantatecla.mastermind.views.console.BoardView;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public abstract class ControllerTest {

    @Mock
    protected BoardView boardView;

    @Mock
    protected ViewFactory viewFactory;

    protected Controller controller;

    protected Board board;

    @Test
    public void testGivenControllerWhenWriteBoardThenWrite(){
        when(this.viewFactory.createBoardView()).thenReturn(this.boardView);
        this.controller.writeBoard();
        int attempts = this.board.getAttempts();
        verify(this.boardView).setAttempts(attempts);
        if (attempts > 0) {
            verify(this.boardView, times(attempts)).setProposedCombinationColors(this.board.getProposedCombinationColors(attempts - 1));
            verify(this.boardView, times(attempts)).setBlacks(this.board.getBlacks(attempts - 1));
            verify(this.boardView, times(attempts)).setWhites(this.board.getWhites(attempts - 1));
        }
        verify(this.boardView).write();
    }

}
