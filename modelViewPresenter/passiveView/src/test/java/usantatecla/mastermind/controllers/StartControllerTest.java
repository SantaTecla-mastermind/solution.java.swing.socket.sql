package usantatecla.mastermind.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.models.BoardBuilder;
import usantatecla.mastermind.views.StartView;

import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StartControllerTest extends ControllerTest {

    @Mock
    private StartView startView;

    @Override
    protected Controller getController(int blacks, int whites, List<String> proposedCombinations) {
        return new StartController(new BoardBuilder()
                .blacks(blacks).whites(whites)
                .proposedCombinations(proposedCombinations)
                .build(), this.viewFactory);
    }

    @Test
    public void testGivenStartControllerWhenControlThenWrite(){
        when(this.viewFactory.createStartView()).thenReturn(this.startView);
        when(this.viewFactory.createBoardView()).thenReturn(this.boardView);
        this.controller = new StartController(new Board(), this.viewFactory);
        ((StartController) this.controller).control();
        verify(this.startView).write();
        verify(this.boardView).setAttempts(0);
        verify(this.boardView).write();
        verifyNoMoreInteractions(this.boardView);
    }

}
