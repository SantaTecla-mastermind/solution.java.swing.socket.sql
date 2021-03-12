package usantatecla.mastermind.controllers;

import org.junit.jupiter.api.Test;
import usantatecla.mastermind.distributed.dispatchers.FrameType;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlayControllerTest extends AcceptorControllerTest {

    @Override
    protected PlayController getServerAcceptorController() {
        return new PlayController(this.session, null);
    }

    @Override
    protected PlayController getClientAcceptorController() {
        return new PlayController(this.session, this.tcpip);
    }

    @Test
    public void testGivenServerPlayControllerWhenUndoableThenReturn() {
        when(this.session.undoable()).thenReturn(false);
        assertThat(this.getServerAcceptorController().undoable(), is(false));
    }

    @Test
    public void testGivenClientPlayControllerWhenUndoableThenReturn() {
        when(this.tcpip.receiveBoolean()).thenReturn(false);
        assertThat(this.getClientAcceptorController().undoable(), is(false));
    }

    @Test
    public void testGivenServerPlayControllerWhenRedoableThenReturn() {
        when(this.session.redoable()).thenReturn(false);
        assertThat(this.getServerAcceptorController().redoable(), is(false));
    }

    @Test
    public void testGivenClientPlayControllerWhenRedoableThenReturn() {
        when(this.tcpip.receiveBoolean()).thenReturn(false);
        assertThat(this.getClientAcceptorController().redoable(), is(false));
    }

    @Test
    public void testGivenServerPlayControllerWhenUndoThenCorrect() {
        this.getServerAcceptorController().undo();
        verify(this.session).undo();
    }

    @Test
    public void testGivenClientPlayControllerWhenUndoThenCorrect() {
        this.getClientAcceptorController().undo();
        verify(this.tcpip).send(FrameType.UNDO.name());
    }

    @Test
    public void testGivenServerPlayControllerWhenRedoThenCorrect() {
        this.getServerAcceptorController().redo();
        verify(this.session).redo();
    }

    @Test
    public void testGivenClientPlayControllerWhenRedoThenCorrect() {
        this.getClientAcceptorController().redo();
        verify(this.tcpip).send(FrameType.REDO.name());
    }

    @Test
    public void testGivenServerPlayControllerWhenGetErrorThenReturn() {
        Error error = Error.NULL;
        when(this.session.getError(any())).thenReturn(error);
        assertThat(this.getServerAcceptorController().getError(Color.get("rgby")), is(error));
    }

    @Test
    public void testGivenClientPlayControllerWhenGetErrorThenReturn() {
        Error error = Error.NULL;
        when(this.tcpip.receiveError()).thenReturn(error);
        assertThat(this.getClientAcceptorController().getError(Color.get("rgby")), is(error));
    }

    @Test
    public void testGivenServerPlayControllerWhenAddThenCorrect() {
        List<Color> colors = Color.get("rgby");
        this.getServerAcceptorController().add(colors);
        verify(this.session).add(colors);
    }

    @Test
    public void testGivenClientPlayControllerWhenAddThenCorrect() {
        List<Color> colors = Color.get("rgby");
        this.getClientAcceptorController().add(colors);
        for (Color color : colors) {
            verify(this.tcpip).send(color);
        }
    }

    @Test
    public void testGivenServerPlayControllerWhenIsFinishedThenReturn() {
        when(this.session.isFinished()).thenReturn(false);
        assertThat(this.getServerAcceptorController().isFinished(), is(false));
    }

    @Test
    public void testGivenClientPlayControllerWhenIsFinishedThenReturn() {
        when(this.tcpip.receiveBoolean()).thenReturn(false);
        assertThat(this.getClientAcceptorController().isFinished(), is(false));
    }

    @Test
    public void testGivenServerPlayControllerWhenIsWinnerThenReturn() {
        when(this.session.isWinner()).thenReturn(false);
        assertThat(this.getServerAcceptorController().isWinner(), is(false));
    }

    @Test
    public void testGivenClientPlayControllerWhenIsWinnerThenReturn() {
        when(this.tcpip.receiveBoolean()).thenReturn(false);
        assertThat(this.getClientAcceptorController().isWinner(), is(false));
    }

}
