package usantatecla.mastermind.distributed.dispatchers;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import usantatecla.mastermind.controllers.PlayController;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class WhitesDispatcherTest extends DispatcherTest {

	@Mock
	private PlayController playController;

	@Override
	protected Dispatcher getDispatcher() {
		return new WhitesDispatcher(this.playController);
	}

	@Test
	public void testGivenWhitesDispatcherWhenDispatchThenCorrect() {
		int whites = 2;
		when(this.tcpip.receiveInt()).thenReturn(1);
		when(this.playController.getWhites(anyInt())).thenReturn(whites);
		this.dispatcher.dispatch();
		verify(this.tcpip).send(whites);
	}

}
