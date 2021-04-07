package usantatecla.mastermind.controllers.proxy;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.distributed.dispatchers.TCPIP;
import usantatecla.mastermind.models.SessionProxy;
import usantatecla.mastermind.models.StateValue;

public class LogicProxy extends Logic {

	private TCPIP tcpip;

	public LogicProxy() {
		this.tcpip = TCPIP.createClientSocket();
		this.session = new SessionProxy(this.tcpip);
		this.acceptorControllers.put(StateValue.INITIAL, new StartControllerProxy(this.tcpip));
		this.acceptorControllers.put(StateValue.IN_GAME, new PlayControllerProxy(this.tcpip));
		this.acceptorControllers.put(StateValue.RESUME, new ResumeControllerProxy(this.tcpip));
		this.acceptorControllers.put(StateValue.EXIT, null);
	}

	public void close() {
		this.tcpip.close();
	}

}
