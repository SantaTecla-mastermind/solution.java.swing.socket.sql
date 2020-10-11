package usantatecla.mastermind.distributed;

import usantatecla.mastermind.distributed.dispatchers.FrameType;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.StateValue;
import usantatecla.utils.TCPIP;

public class SessionProxy implements Session {
	
	private TCPIP tcpip;

	public SessionProxy(TCPIP tcpip) {
		this.tcpip = tcpip;
	}
	
	
	public StateValue getValueState() {
		this.tcpip.send(FrameType.STATE.name());
		return StateValue.values()[this.tcpip.receiveInt()];
	}

	
	public int getWidth() {
		this.tcpip.send(FrameType.WIDTH.name());
		return this.tcpip.receiveInt();
	}

}
