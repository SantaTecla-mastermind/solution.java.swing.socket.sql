package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.implementation.AcceptorControllerImplementation;

public abstract class Dispatcher {
	
	protected AcceptorControllerImplementation acceptorControllerImplementation;
	
	protected TCPIP tcpip;
	
	public Dispatcher (AcceptorControllerImplementation acceptorControllerImplementation) {
		this.acceptorControllerImplementation = acceptorControllerImplementation;
	}

	public abstract void dispatch();
	
	public void associate(TCPIP tcpip) {
		this.tcpip = tcpip;
	}

}
