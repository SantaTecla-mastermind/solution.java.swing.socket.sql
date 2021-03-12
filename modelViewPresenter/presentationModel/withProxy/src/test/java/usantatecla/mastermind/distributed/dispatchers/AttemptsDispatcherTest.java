package usantatecla.mastermind.distributed.dispatchers;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import usantatecla.mastermind.controllers.PlayController;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AttemptsDispatcherTest extends DispatcherTest {

	@Mock
	private PlayController playController;

	@Override
	protected Dispatcher getDispatcher() {
		return new AttemptsDispatcher(this.playController);
	}

	@Test
	public void testGivenAttemptsDispatcherWhenDispatchThenCorrect() {
		int attempts = 1;
		when(this.playController.getAttempts()).thenReturn(attempts);
		this.dispatcher.dispatch();
		verify(this.tcpip).send(attempts);
	}

}
