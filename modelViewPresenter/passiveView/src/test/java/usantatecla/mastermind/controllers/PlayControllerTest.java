package usantatecla.mastermind.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.models.BoardBuilder;
import usantatecla.mastermind.types.Error;
import usantatecla.mastermind.views.ErrorView;
import usantatecla.mastermind.views.console.PlayView;
import usantatecla.mastermind.views.console.ProposedCombinationView;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayControllerTest extends ControllerTest{

    private static final String INITIALS = "rgby";

    @Mock
    private PlayView playView;

    @Mock
    private ProposedCombinationView proposedCombinationView;

    @Mock
    private ErrorView errorView;

    @Override
    protected Controller getController(int blacks, int whites, List<String> proposedCombinations) {
        return new PlayController(new BoardBuilder()
                .blacks(blacks).whites(whites)
                .proposedCombinations(proposedCombinations)
                .build(), this.viewFactory);
    }

    @Test
    public void testGivenPlayControllerWhenControlThenIsWinner(){
        this.setUpMocks();
        when(this.proposedCombinationView.read()).thenReturn(PlayControllerTest.INITIALS);
        this.controller = this.getController(4, 0, new ArrayList<>());
        ((PlayController) this.controller).control();
        verify(this.playView).writeWinner();
    }

    private void setUpMocks() {
        when(this.viewFactory.createPlayView()).thenReturn(this.playView);
        when(this.viewFactory.createBoardView()).thenReturn(this.boardView);
        when(this.viewFactory.createProposedCombinationView()).thenReturn(this.proposedCombinationView);
        when(this.viewFactory.createErrorView()).thenReturn(this.errorView);
    }

    @Test
    public void testGivenPlayControllerWhenControlThenIsLooser(){
        this.setUpMocks();
        when(this.proposedCombinationView.read()).thenReturn(PlayControllerTest.INITIALS);
        List<String> colors = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            colors.add(PlayControllerTest.INITIALS);
        }
        this.controller = this.getController(2, 2, colors);
        ((PlayController) this.controller).control();
        verify(this.playView).writeLooser();
    }

    @Test
    void testGivenPlayControllerControlThenWrongWidthProposedCombination() {
        this.setUpMocks();
        when(this.proposedCombinationView.read()).thenReturn("rg", "rgbyo", PlayControllerTest.INITIALS);
        this.controller = this.getController(4, 0, new ArrayList<>());
        ((PlayController) this.controller).control();
        verify(this.errorView, times(2)).writeln(Error.WRONG_LENGTH);
    }

    @Test
    void testGivenWrongCharactersProposedCombinationWhenReadThenCorrectErrorIsCaptured() {
        this.setUpMocks();
        when(this.proposedCombinationView.read()).thenReturn("rqcp", "rpfi", "p^l0", PlayControllerTest.INITIALS);
        this.controller = this.getController(4, 0, new ArrayList<>());
        ((PlayController) this.controller).control();
        verify(this.errorView, times(3)).writeln(Error.WRONG_CHARACTERS);
    }

    @Test
    void testGivenDuplicatedCharacterProposedCombinationWhenReadThenCorrectErrorIsCaptured() {
        this.setUpMocks();
        when(this.proposedCombinationView.read()).thenReturn("rmmg", "rrrr", "ygyg", PlayControllerTest.INITIALS);
        this.controller = this.getController(4, 0, new ArrayList<>());
        ((PlayController) this.controller).control();
        verify(this.errorView, times(3)).writeln(Error.DUPLICATED);
    }

}
