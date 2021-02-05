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
import usantatecla.mastermind.views.console.PlayView;
import usantatecla.mastermind.views.console.ProposedCombinationView;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlayControllerTest extends ControllerTest{

    @Mock
    private PlayView playView;

    @Mock
    private ProposedCombinationView proposedCombinationView;

    Board board;

    @BeforeEach
    public void beforeEach(){
        when(this.viewFactory.createPlayView()).thenReturn(this.playView);
        when(this.viewFactory.createBoardView()).thenReturn(this.boardView);
        when(this.viewFactory.createProposedCombinationView()).thenReturn(this.proposedCombinationView);
        when(this.proposedCombinationView.read()).thenReturn(Color.get("rgby"));
    }

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

}
