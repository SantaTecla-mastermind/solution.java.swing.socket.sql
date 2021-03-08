package usantatecla.mastermind.distributed.dispatchers;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import usantatecla.mastermind.controllers.PlayController;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class BlacksDispatcherTest extends DispatcherTest {

	@Mock
	private PlayController playController;

	@Override
	protected Dispatcher getDispatcher() {
		return new BlacksDispatcher(this.playController);
	}

	@Test
	public void testGivenBlacksDispatcherWhenDispatchThenCorrect() {
		int blacks = 2;
		when(this.tcpip.receiveInt()).thenReturn(1);
		when(this.playController.getBlacks(anyInt())).thenReturn(blacks);
		this.dispatcher.dispatch();
		verify(this.tcpip).send(blacks);
	}

}
