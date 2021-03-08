package usantatecla.mastermind.distributed.dispatchers;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.types.Color;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ColorsDispatcherTest extends DispatcherTest {

	@Mock
	private PlayController playController;

	@Override
	protected Dispatcher getDispatcher() {
		return new ColorsDispatcher(this.playController);
	}

	@Test
	public void testGivenColorsDispatcherWhenDispatchThenCorrect() {
		List<Color> colors = Color.get("rgbc");
		when(this.tcpip.receiveInt()).thenReturn(1);
		when(this.playController.getProposedCombinationColors(anyInt())).thenReturn(colors);
		this.dispatcher.dispatch();
		verify(this.tcpip).send(colors.size());
		for (Color color : colors) {
			verify(this.tcpip).send(color);
		}
	}

}
