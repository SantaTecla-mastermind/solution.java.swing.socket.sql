package usantatecla.mastermind.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.views.ViewFactory;
import usantatecla.mastermind.views.console.BoardView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public abstract class ControllerTest {

    @Mock
    protected BoardView boardView;

    @Mock
    protected ViewFactory viewFactory;

    protected Controller controller;

    @Test
    public void testGivenControllerWhenWriteBoardThenWrite(){
        when(this.viewFactory.createBoardView()).thenReturn(this.boardView);
        int blacks = 2;
        int whites = 2;
        int attempts = 3;
        List<String> proposedCombinations = new ArrayList<>(Arrays.asList(
                "rgby",
                "mcry",
                "ycmr"
        ));
        this.controller = this.getController(blacks, whites, proposedCombinations);
        this.controller.writeBoard();
        verify(this.boardView).setAttempts(attempts);
        verify(this.boardView, times(attempts)).setBlacks(blacks);
        verify(this.boardView, times(attempts)).setWhites(whites);
        for (String proposedCombination : proposedCombinations) {
            verify(this.boardView).setProposedCombinationColors(Color.get(proposedCombination));
        }

    }

    protected abstract Controller getController(int blacks, int whites, List<String> proposedCombinations);

}
