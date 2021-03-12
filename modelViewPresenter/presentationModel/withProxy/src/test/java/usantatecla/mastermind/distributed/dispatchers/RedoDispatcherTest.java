package usantatecla.mastermind.distributed.dispatchers;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import usantatecla.mastermind.controllers.PlayController;

import static org.mockito.Mockito.verify;

public class RedoDispatcherTest extends DispatcherTest {

	@Mock
	private PlayController playController;

	@Override
	protected Dispatcher getDispatcher() {
		return new RedoDispatcher(this.playController);
	}

	@Test
	public void testGivenRedoDispatcherWhenDispatchThenCorrect() {
		this.dispatcher.dispatch();
		verify(this.playController).redo();
	}

}
