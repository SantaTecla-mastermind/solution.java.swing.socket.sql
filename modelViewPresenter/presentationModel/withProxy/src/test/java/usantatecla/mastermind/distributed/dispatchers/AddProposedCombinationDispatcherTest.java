package usantatecla.mastermind.distributed.dispatchers;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.models.Result;
import usantatecla.mastermind.types.Color;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class AddProposedCombinationDispatcherTest extends DispatcherTest {

	@Mock
	private PlayController playController;

	@Override
	protected Dispatcher getDispatcher() {
		return new AddProposedCombinationDispatcher(this.playController);
	}

	@Test
	public void testGivenAddProposedCombinationDispatcherWhenDispatchThenCorrect() {
		when(this.tcpip.receiveInt()).thenReturn(Result.WIDTH);
		when(this.tcpip.receiveColor()).thenReturn(Color.RED, Color.GREEN, Color.BLUE, Color.CYAN);
		this.dispatcher.dispatch();
		verify(this.playController).add(Color.get("rgbc"));
	}

}
