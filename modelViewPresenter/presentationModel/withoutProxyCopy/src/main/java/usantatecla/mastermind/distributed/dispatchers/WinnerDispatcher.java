package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.PlayController;

public class WinnerDispatcher extends Dispatcher {

	public WinnerDispatcher(PlayController playController) {
		super(playController);
	}

	@Override
	public void dispatch() {
		tcpip.send(((PlayController)this.acceptorController).isWinner());
	}

}
