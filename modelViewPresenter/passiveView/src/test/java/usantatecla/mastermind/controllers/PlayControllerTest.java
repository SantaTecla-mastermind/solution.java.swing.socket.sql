package usantatecla.mastermind.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.models.BoardBuilder;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.mastermind.views.ErrorView;
import usantatecla.mastermind.views.console.PlayView;
import usantatecla.mastermind.views.console.ProposedCombinationView;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayControllerTest extends ControllerTest {

    private static final String INITIALS = "rgby";

    @Mock
    private PlayView playView;

    @Mock
    private ProposedCombinationView proposedCombinationView;

    @Mock
    private ErrorView errorView;
    
    @BeforeEach
    public void beforeEach() {
        this.board = new BoardBuilder()
                .blacks(2).whites(2)
                .proposedCombinations(9, PlayControllerTest.INITIALS)
                .build();
        this.controller = new PlayController(this.board, this.viewFactory);
    }

    @Test
    public void testGivenPlayControllerWhenControlThenIsWinner(){
        this.setUpMocks();
        when(this.proposedCombinationView.read()).thenReturn(Color.get(PlayControllerTest.INITIALS));
        this.controller = this.getWinnerPlayController();
        ((PlayController) this.controller).control();
        verify(this.playView).writeWinner();
    }

    private void setUpMocks() {
        when(this.viewFactory.createPlayView()).thenReturn(this.playView);
        when(this.viewFactory.createBoardView()).thenReturn(this.boardView);
        when(this.viewFactory.createProposedCombinationView()).thenReturn(this.proposedCombinationView);
        when(this.viewFactory.createErrorView()).thenReturn(this.errorView);
    }
    
    private PlayController getWinnerPlayController() {
        this.board = new BoardBuilder()
                .blacks(4).whites(0)
                .build();
        return new PlayController(this.board, this.viewFactory);
    }

    @Test
    public void testGivenPlayControllerWhenControlThenIsLooser(){
        this.setUpMocks();
        when(this.proposedCombinationView.read()).thenReturn(Color.get(PlayControllerTest.INITIALS));
        ((PlayController) this.controller).control();
        verify(this.playView).writeLooser();
    }

    @Test
    void testGivenPlayControllerControlThenWrongWidthProposedCombination() {
        this.setUpMocks();
        when(this.proposedCombinationView.read()).thenReturn(Color.get("rg"),
                Color.get("rgbyo"), Color.get(PlayControllerTest.INITIALS));
        this.controller = this.getWinnerPlayController();
        ((PlayController) this.controller).control();
        verify(this.errorView, times(2)).writeln(Error.WRONG_LENGTH);
    }

    @Test
    void testGivenWrongCharactersProposedCombinationWhenReadThenCorrectErrorIsCaptured() {
        this.setUpMocks();
        when(this.proposedCombinationView.read()).thenReturn(Color.get("rqcp"),
                Color.get("rpfi"), Color.get("p^l0"), Color.get(PlayControllerTest.INITIALS));
        this.controller = this.getWinnerPlayController();
        ((PlayController) this.controller).control();
        verify(this.errorView, times(3)).writeln(Error.WRONG_CHARACTERS);
    }

    @Test
    void testGivenDuplicatedCharacterProposedCombinationWhenReadThenCorrectErrorIsCaptured() {
        this.setUpMocks();
        when(this.proposedCombinationView.read()).thenReturn(Color.get("rmmg"),
                Color.get("rrrr"), Color.get("ygyg"), Color.get(PlayControllerTest.INITIALS));
        this.controller = this.getWinnerPlayController();
        ((PlayController) this.controller).control();
        verify(this.errorView, times(3)).writeln(Error.DUPLICATED);
    }

}
