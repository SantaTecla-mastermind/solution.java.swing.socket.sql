package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.types.Color;

import java.util.List;

public class ColorsDispatcher extends Dispatcher {

	public ColorsDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		int position = this.tcpip.receiveInt();
		List<Color> colors = this.acceptorController.getProposedCombinationColors(position);
		this.tcpip.send(colors.size());
		for (Color color: colors) {
			this.tcpip.send(color);
		}
	}

}
