package usantatecla.mastermind.distributed;

import usantatecla.mastermind.Mastermind;
import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.controllers.proxy.LogicProxy;
import usantatecla.mastermind.views.console.ConsoleView;

public class ConsoleMastermindClient extends Mastermind {

	@Override
	protected ConsoleView createView() {
		return new ConsoleView();
	}

	@Override
	protected Logic createLogic() {
		return new LogicProxy();
	}

	@Override
	protected void play() {
		super.play();
		((LogicProxy) this.logic).close();
	}

	public static void main(String[] args) {
		new ConsoleMastermindClient().play();
	}

}
