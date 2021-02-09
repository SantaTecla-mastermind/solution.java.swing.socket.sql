package usantatecla.mastermind.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.models.BoardBuilder;
import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.mastermind.views.ErrorView;
import usantatecla.mastermind.views.ViewFactory;
import usantatecla.mastermind.views.console.BoardView;
import usantatecla.mastermind.views.console.PlayView;
import usantatecla.mastermind.views.console.ProposedCombinationView;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayControllerTest {

    private static final String INITIALS = "rgby";

    @Mock
    private PlayView playView;

    @Mock
    private ProposedCombinationView proposedCombinationView;

    @Mock
    private BoardView boardView;

    @Mock
    private ViewFactory viewFactory;

    private Board board;

    private PlayController playController;

    @Mock
    private ErrorView errorView;

    @Test
    public void testGivenPlayControllerWhenControlThenIsWinner(){
        this.playController = this.getWinnerPlayController();
        this.setUpMocks();
        when(this.proposedCombinationView.read()).thenReturn(new ProposedCombination(Color.get(PlayControllerTest.INITIALS)));
        this.playController.control();
        verify(this.playView).writeWinner();
    }

    private void setUpMocks() {
        when(this.viewFactory.createPlayView()).thenReturn(this.playView);
        when(this.viewFactory.createBoardView(this.board)).thenReturn(this.boardView);
        when(this.viewFactory.createProposedCombinationView()).thenReturn(this.proposedCombinationView);
        when(this.viewFactory.createErrorView()).thenReturn(this.errorView);
    }

    private PlayController getWinnerPlayController() {
        this.board = new BoardBuilder()
                .blacks(4).whites(0)
                .build();
        return new PlayController(this.board, this.viewFactory);
    }

    private PlayController getLooserPlayController() {
        this.board = new BoardBuilder()
                .proposedCombinations(9,PlayControllerTest.INITIALS)
                .blacks(0).whites(4)
                .build();
        return new PlayController(this.board, this.viewFactory);
    }

    @Test
    public void testGivenPlayControllerWhenControlThenIsLooser(){
        this.playController = this.getLooserPlayController();
        this.setUpMocks();
        when(this.proposedCombinationView.read()).thenReturn(new ProposedCombination(Color.get(PlayControllerTest.INITIALS)));
        this.playController.control();
        verify(this.playView).writeLooser();
    }

    @Test
    void testGivenPlayControllerControlThenWrongWidthProposedCombination() {
        this.playController = this.getWinnerPlayController();
        this.setUpMocks();
        when(this.proposedCombinationView.read()).thenReturn(
                new ProposedCombination(Color.get("rg")),
                new ProposedCombination(Color.get("rgbyo")),
                new ProposedCombination(Color.get(PlayControllerTest.INITIALS)));
        this.playController.control();
        verify(this.errorView, times(2)).writeln(Error.WRONG_LENGTH);
    }

    @Test
    void testGivenWrongCharactersProposedCombinationWhenReadThenCorrectErrorIsCaptured() {
        this.playController = this.getWinnerPlayController();
        this.setUpMocks();
        when(this.proposedCombinationView.read()).thenReturn(
                new ProposedCombination(Color.get("rqcp")),
                new ProposedCombination(Color.get("rpfi")),
                new ProposedCombination(Color.get("p^l0")),
                new ProposedCombination(Color.get(PlayControllerTest.INITIALS)));
        this.playController.control();
        verify(this.errorView, times(3)).writeln(Error.WRONG_CHARACTERS);
    }

    @Test
    void testGivenDuplicatedCharacterProposedCombinationWhenReadThenCorrectErrorIsCaptured() {
        this.playController = this.getWinnerPlayController();
        this.setUpMocks();
        when(this.proposedCombinationView.read()).thenReturn(
                new ProposedCombination(Color.get("rmmg")),
                new ProposedCombination(Color.get("rrrr")),
                new ProposedCombination(Color.get("ygyg")),
                new ProposedCombination(Color.get(PlayControllerTest.INITIALS)));
        this.playController.control();
        verify(this.errorView, times(3)).writeln(Error.DUPLICATED);
    }

}
