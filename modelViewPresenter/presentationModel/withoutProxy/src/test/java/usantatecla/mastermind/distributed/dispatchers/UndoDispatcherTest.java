package usantatecla.mastermind.distributed.dispatchers;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import usantatecla.mastermind.controllers.PlayController;

import static org.mockito.Mockito.verify;

public class UndoDispatcherTest extends DispatcherTest {

	@Mock
	private PlayController playController;

	@Override
	protected Dispatcher getDispatcher() {
		return new UndoDispatcher(this.playController);
	}

	@Test
	public void testGivenUndoDispatcherWhenDispatchThenCorrect() {
		this.dispatcher.dispatch();
		verify(this.playController).undo();
	}

}
