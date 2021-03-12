package usantatecla.mastermind.distributed;

import usantatecla.mastermind.distributed.dispatchers.DispatcherPrototype;
import usantatecla.mastermind.models.Session;

public class MastermindServer {

	private DispatcherPrototype dispatcherPrototype;
	private LogicServer logic;

	private MastermindServer() {
		this.dispatcherPrototype = new DispatcherPrototype();
		this.logic = new LogicServer(new Session(), true);
		this.logic.createDispatchers(this.dispatcherPrototype);
	}

	private void serve() {
		this.dispatcherPrototype.serve();
	}

	public static void main(String[] args) {
		new MastermindServer().serve();
	}

}
