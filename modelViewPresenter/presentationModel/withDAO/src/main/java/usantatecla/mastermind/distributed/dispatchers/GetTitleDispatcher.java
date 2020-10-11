package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.implementation.SaveControllerImplementation;

public class GetTitleDispatcher extends Dispatcher {

	public GetTitleDispatcher(SaveControllerImplementation saveControllerImplementation) {
		super(saveControllerImplementation);
	}

	@Override
	public void dispatch() {
		this.tcpip.send(this.acceptorController.getName());
	}

}
