package usantatecla.mastermind.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.StartView;
import usantatecla.mastermind.views.ViewFactory;
import usantatecla.mastermind.views.console.BoardView;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StartControllerTest {

    @Mock
    private StartView startView;

    @Mock
    private BoardView boardView;

    @Mock
    private ViewFactory viewFactory;

    private StartController startController;

    @BeforeEach
    public void beforeEach() {
        this.startController = new StartController(new Board(), this.viewFactory);
    }

    @Test
    public void testGivenStartControllerWhenControlThenWrite(){
        when(this.viewFactory.createStartView()).thenReturn(this.startView);
        when(this.viewFactory.createBoardView(any())).thenReturn(this.boardView);
        this.startController.control();
        verify(this.startView).write();
        verify(this.boardView).write();
        verifyNoMoreInteractions(this.boardView);
    }

}
