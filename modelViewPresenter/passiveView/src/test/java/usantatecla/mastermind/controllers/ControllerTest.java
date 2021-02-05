package usantatecla.mastermind.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.views.ViewFactory;
import usantatecla.mastermind.views.console.BoardView;
import usantatecla.utils.views.Console;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public abstract class ControllerTest {

    @Mock
    protected BoardView boardView;

    @Mock
    protected ViewFactory viewFactory;

    protected Controller controller;

    @BeforeEach
    public void beforeEach(){
        when(this.viewFactory.createBoardView()).thenReturn(this.boardView);
        this.controller.writeBoard();
    }

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

    protected abstract Controller getController();



}
