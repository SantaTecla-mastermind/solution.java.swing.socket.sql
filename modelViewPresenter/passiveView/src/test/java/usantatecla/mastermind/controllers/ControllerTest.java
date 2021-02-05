package usantatecla.mastermind.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
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

    /*@Test
    public void testGivenControllerWhenWriteBoardThenWrite(){
        when(this.viewFactory.createBoardView()).thenReturn(this.boardView);
        this.controller.writeBoard();
        verify(this.boardView).write();
    }*/

}
