package usantatecla.mastermind.controllers.proxy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usantatecla.mastermind.distributed.dispatchers.FrameType;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlayControllerProxyTest extends AcceptorControllerProxyTest {

    @BeforeEach
    public void beforeEach() {
        this.acceptorController = new PlayControllerProxy(this.tcpip);
    }

    @Test
    public void testGivenPlayControllerProxyWhenUndoableThenReturn() {
        when(this.tcpip.receiveBoolean()).thenReturn(false);
        assertThat(((PlayControllerProxy) this.acceptorController).undoable(), is(false));
    }

    @Test
    public void testGivenPlayControllerProxyWhenRedoableThenReturn() {
        when(this.tcpip.receiveBoolean()).thenReturn(false);
        assertThat(((PlayControllerProxy) this.acceptorController).redoable(), is(false));
    }

    @Test
    public void testGivenPlayControllerProxyWhenUndoThenCorrect() {
        ((PlayControllerProxy) this.acceptorController).undo();
        verify(this.tcpip).send(FrameType.UNDO.name());
    }

    @Test
    public void testGivenPlayControllerProxyWhenRedoThenCorrect() {
        ((PlayControllerProxy) this.acceptorController).redo();
        verify(this.tcpip).send(FrameType.REDO.name());
    }

    @Test
    public void testGivenPlayControllerProxyWhenGetErrorThenReturn() {
        Error error = Error.NULL;
        when(this.tcpip.receiveError()).thenReturn(error);
        assertThat(((PlayControllerProxy) this.acceptorController)
                .getError(Color.get("rgby")), is(error));
    }

    @Test
    public void testGivenPlayControllerProxyWhenAddThenCorrect() {
        List<Color> colors = Color.get("rgby");
        ((PlayControllerProxy) this.acceptorController).add(colors);
        for (Color color : colors) {
            verify(this.tcpip).send(color);
        }
    }

    @Test
    public void testGivenPlayControllerProxyWhenIsFinishedThenReturn() {
        when(this.tcpip.receiveBoolean()).thenReturn(false);
        assertThat(((PlayControllerProxy) this.acceptorController).isFinished(), is(false));
    }

    @Test
    public void testGivenPlayControllerProxyWhenIsWinnerThenReturn() {
        when(this.tcpip.receiveBoolean()).thenReturn(false);
        assertThat(((PlayControllerProxy) this.acceptorController).isWinner(), is(false));
    }

}
