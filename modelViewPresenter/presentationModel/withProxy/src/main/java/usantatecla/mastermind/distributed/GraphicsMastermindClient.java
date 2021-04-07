package usantatecla.mastermind.distributed;

import usantatecla.mastermind.Mastermind;
import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.controllers.proxy.LogicProxy;
import usantatecla.mastermind.views.graphics.GraphicsView;

public class GraphicsMastermindClient extends Mastermind {

	@Override
	protected GraphicsView createView() {
		return new GraphicsView();
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
		new GraphicsMastermindClient().play();
	}

}
