package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.implementation.PlayControllerImplementation;
import usantatecla.mastermind.types.Color;

import java.util.ArrayList;
import java.util.List;

public class AddProposedCombinationDispatcher extends Dispatcher {

	public AddProposedCombinationDispatcher(PlayControllerImplementation playControllerImplementation) {
		super(playControllerImplementation);
	}

	@Override
	public void dispatch() {
		int size = this.tcpip.receiveInt();
		List<Color> colors = new ArrayList<Color>();
		for (int i=0; i<size; i++) {
			colors.add(this.tcpip.receiveColor());
		}
		((PlayControllerImplementation) this.acceptorControllerImplementation).add(colors);
	}

}
