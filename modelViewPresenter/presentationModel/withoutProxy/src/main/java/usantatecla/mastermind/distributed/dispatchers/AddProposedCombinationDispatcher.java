package usantatecla.mastermind.distributed.dispatchers;

import java.util.ArrayList;
import java.util.List;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.types.Color;

public class AddProposedCombinationDispatcher extends Dispatcher {

	public AddProposedCombinationDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		int length = this.tcpip.receiveInt();
		List<Color> colors = new ArrayList<Color>();
		for (int i=0; i<length; i++) {
			colors.add(this.tcpip.receiveColor());
		}
		((PlayController) this.acceptorController).add(colors);
	}

}
