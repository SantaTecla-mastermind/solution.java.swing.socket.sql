package usantatecla.mastermind.distributed;

import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.distributed.dispatchers.FrameType;
import usantatecla.mastermind.models.Session;
import usantatecla.utils.TCPIP;

public class StartControllerProxy extends StartController {
	
	private TCPIP tcpip;

	public StartControllerProxy(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	@Override
	public void start() {
		this.tcpip.send(FrameType.START.name());
	}

}
