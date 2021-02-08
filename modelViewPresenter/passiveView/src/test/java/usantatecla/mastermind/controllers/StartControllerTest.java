package usantatecla.mastermind.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.StartView;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StartControllerTest extends ControllerTest {

    @Mock
    private StartView startView;

    @BeforeEach
    public void beforeEach() {
        this.board = new Board();
        this.controller = new StartController(this.board, this.viewFactory);
    }

    @Test
    public void testGivenStartControllerWhenControlThenWrite(){
        when(this.viewFactory.createStartView()).thenReturn(this.startView);
        when(this.viewFactory.createBoardView()).thenReturn(this.boardView);
        ((StartController) this.controller).control();
        verify(this.startView).write();
        verify(this.boardView).setAttempts(0);
        verify(this.boardView).write();
        verifyNoMoreInteractions(this.boardView);
    }

}
