package usantatecla.mastermind.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.models.BoardBuilder;
import usantatecla.mastermind.views.ErrorView;
import usantatecla.mastermind.views.console.PlayView;
import usantatecla.mastermind.views.console.ProposedCombinationView;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayControllerTest extends ControllerTest{

    @Mock
    private PlayView playView;

    @Mock
    private ProposedCombinationView proposedCombinationView;

    @Mock
    private ErrorView errorView;

    private Board board;

    @Override
    protected Controller getController(int blacks, int whites, List<String> proposedCombinations) {
        this.board = new BoardBuilder()
                .blacks(blacks).whites(whites)
                .proposedCombinations(proposedCombinations)
                .build();
        return new PlayController(this.board, this.viewFactory);
    }

    @Test
    public void testGivenPlayControllerWhenControlThenIsWinner(){
        this.setUpMocks();
        when(this.proposedCombinationView.read()).thenReturn("rgby");
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

    // TODO Tests

    /*
    @Test
    public void testGivenPlayControllerWhenControlThenIsWinner(){
        this.board = new BoardBuilder()
                .proposedCombinations(1,"rgby")
                .blacks(4)
                .whites(4)
                .build();
        this.controller = new PlayController(this.board, this.viewFactory);
        ((PlayController) this.controller).control();
        assertThat(this.board.isWinner(),is(true));
        assertThat(this.board.isFinished(),is(true));
        verify(this.playView).writeWinner();
    }

    @Test
    public void testGivenPlayControllerWhenControlThenIsLooser(){
        this.board = new BoardBuilder()
                .proposedCombinations(9,"rgby")
                .blacks(0)
                .whites(4)
                .build();
        this.controller = new PlayController(this.board, this.viewFactory);
        ((PlayController) this.controller).control();
        assertThat(this.board.isWinner(),is(false));
        assertThat(this.board.isFinished(),is(true));
        verify(this.playView).writeLooser();
    }
    */
}
