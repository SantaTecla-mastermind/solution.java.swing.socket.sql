package usantatecla.mastermind.distributed.dispatchers;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import usantatecla.mastermind.controllers.PlayController;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class WinnerDispatcherTest extends DispatcherTest {

	@Mock
	private PlayController playController;

	@Override
	protected Dispatcher getDispatcher() {
		return new WinnerDispatcher(this.playController);
	}

	@Test
	public void testGivenWinnerDispatcherWhenDispatchThenCorrect() {
		when(this.playController.isWinner()).thenReturn(false);
		this.dispatcher.dispatch();
		verify(this.tcpip).send(false);
	}

}
