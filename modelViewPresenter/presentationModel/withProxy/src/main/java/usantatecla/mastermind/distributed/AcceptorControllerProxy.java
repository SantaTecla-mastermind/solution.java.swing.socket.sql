package usantatecla.mastermind.distributed;

import usantatecla.mastermind.controllers.Controller;
import usantatecla.mastermind.controllers.ControllersVisitor;
import usantatecla.mastermind.distributed.dispatchers.FrameType;
import usantatecla.mastermind.distributed.dispatchers.TCPIP;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.StateValue;
import usantatecla.mastermind.types.Color;

import java.util.ArrayList;
import java.util.List;

public abstract class AcceptorControllerProxy extends Controller {

	protected TCPIP tcpip;

	AcceptorControllerProxy(Session session, TCPIP tcpip) {
		super(session);
		this.tcpip = tcpip;
	}

	public void nextState() {
		if (this.tcpip == null) {
			this.session.nextState();
		} else {
			this.tcpip.send(FrameType.NEXT_STATE.name());
		}
	}

	public StateValue getStateValue() {
		if (this.tcpip == null) {
			return this.session.getValueState();
		} else {
			this.tcpip.send(FrameType.STATE_VALUE.name());
			return StateValue.valueOf(this.tcpip.receiveLine());
		}
	}

	public int getAttempts() {
		if (this.tcpip == null) {
			return this.session.getAttempts();
		} else {
			this.tcpip.send(FrameType.ATTEMPTS.name());
			return this.tcpip.receiveInt();
		}
	}

	public List<Color> getProposedCombinationColors(int position) {
		if (this.tcpip == null) {
			return this.session.getProposedCombinationColors(position);
		} else {
			this.tcpip.send(FrameType.COLORS.name());
			this.tcpip.send(position);
			int size = this.tcpip.receiveInt();
			List<Color> colors = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				colors.add(this.tcpip.receiveColor());
			}
			return colors;
		}
	}

	public int getBlacks(int position) {
		if (this.tcpip == null) {
			return this.session.getBlacks(position);
		} else {
			this.tcpip.send(FrameType.BLACKS.name());
			this.tcpip.send(position);
			return this.tcpip.receiveInt();
		}
	}

	public int getWhites(int position) {
		if (this.tcpip == null) {
			return this.session.getWhites(position);
		} else {
			this.tcpip.send(FrameType.WHITES.name());
			this.tcpip.send(position);
			return this.tcpip.receiveInt();
		}
	}

	public abstract void accept(ControllersVisitor controllersVisitor);

}
