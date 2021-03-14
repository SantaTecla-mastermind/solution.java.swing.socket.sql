package usantatecla.mastermind.controllers.implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlayControllerImplementationTest extends AcceptorControllerImplementationTest {

    @BeforeEach
    public void beforeEach() {
        this.acceptorController = new PlayControllerImplementation(this.session);
    }

    @Test
    public void testGivenPlayControllerImplementationWhenUndoableThenReturn() {
        when(this.session.undoable()).thenReturn(false);
        assertThat(((PlayControllerImplementation) this.acceptorController).undoable(), is(false));
    }

    @Test
    public void testGivenPlayControllerImplementationWhenRedoableThenReturn() {
        when(this.session.redoable()).thenReturn(false);
        assertThat(((PlayControllerImplementation) this.acceptorController).redoable(), is(false));
    }

    @Test
    public void testGivenPlayControllerImplementationWhenUndoThenCorrect() {
        ((PlayControllerImplementation) this.acceptorController).undo();
        verify(this.session).undo();
    }

    @Test
    public void testGivenPlayControllerImplementationWhenRedoThenCorrect() {
        ((PlayControllerImplementation) this.acceptorController).redo();
        verify(this.session).redo();
    }

    @Test
    public void testGivenPlayControllerImplementationWhenGetErrorThenReturn() {
        Error error = Error.NULL;
        when(this.session.getError(any())).thenReturn(error);
        assertThat(((PlayControllerImplementation) this.acceptorController).getError(Color.get("rgby")), is(error));
    }

    @Test
    public void testGivenPlayControllerImplementationWhenAddThenCorrect() {
        List<Color> colors = Color.get("rgby");
        ((PlayControllerImplementation) this.acceptorController).add(colors);
        verify(this.session).add(colors);
    }

    @Test
    public void testGivenPlayControllerImplementationWhenIsFinishedThenReturn() {
        when(this.session.isFinished()).thenReturn(false);
        assertThat(((PlayControllerImplementation) this.acceptorController).isFinished(), is(false));
    }

    @Test
    public void testGivenPlayControllerImplementationWhenIsWinnerThenReturn() {
        when(this.session.isWinner()).thenReturn(false);
        assertThat(((PlayControllerImplementation) this.acceptorController).isWinner(), is(false));
    }

}
