package usantatecla.mastermind.distributed.dispatchers;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import usantatecla.mastermind.controllers.PlayController;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UndoableDispatcherTest extends DispatcherTest {

	@Mock
	private PlayController playController;

	@Override
	protected Dispatcher getDispatcher() {
		return new UndoableDispatcher(this.playController);
	}

	@Test
	public void testGivenUndoableDispatcherWhenDispatchThenCorrect() {
		when(this.playController.undoable()).thenReturn(false);
		this.dispatcher.dispatch();
		verify(this.tcpip).send(false);
	}

}
