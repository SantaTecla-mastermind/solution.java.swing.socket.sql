package usantatecla.mastermind.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.models.BoardBuilder;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.views.StartView;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StartControllerTest extends ControllerTest{

    @Mock
    private StartView startView;

    /*
    @BeforeEach
    public void beforeEach(){
        when(this.viewFactory.createStartView()).thenReturn(this.startView);
        when(this.viewFactory.createBoardView()).thenReturn(this.boardView);

        this.controller = this.getController(0, 0, new ArrayList<>());
        ((StartController) this.controller).control();
        verify(this.startView).write();
    }*/

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

    // TODO Revisar tests de debajo
    /*
    @Test
    public void testGivenStartControllerWhenControlThenCorrectAttempts(){
        ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(this.boardView, atLeastOnce()).setAttempts(argumentCaptor.capture());
        assertThat(argumentCaptor.getAllValues().get(0), is(0));
    }

    @Test
    public void testGivenStartControllerWhenControlThenCorrectProposedCombinations(){
        ArgumentCaptor<List<Color>> argumentCaptor = ArgumentCaptor.forClass(List.class);
        verify(this.boardView, never()).setProposedCombinationColors(argumentCaptor.capture());
        assertThat(argumentCaptor.getAllValues().size(), is(0));
    }

    @Test
    public void testGivenStartControllerWhenControlThenCorrectBlacks(){
        ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(this.boardView, never()).setBlacks(argumentCaptor.capture());
        assertThat(argumentCaptor.getAllValues().size(), is(0));
    }

    @Test
    public void testGivenStartControllerWhenControlThenCorrectWhites(){
        ArgumentCaptor<Integer> argumentCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(this.boardView, never()).setWhites(argumentCaptor.capture());
        assertThat(argumentCaptor.getAllValues().size(), is(0));
    }
     */

}
