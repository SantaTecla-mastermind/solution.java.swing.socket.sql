package usantatecla.mastermind.distributed;

import usantatecla.mastermind.Mastermind;
import usantatecla.mastermind.views.graphics.GraphicsView;

public class GraphicsMastermindClient extends Mastermind {

	@Override
	protected GraphicsView createView() {
		return new GraphicsView();
	}

	@Override
	protected Boolean isStandalone() {
		return false;
	}
	
	public static void main(String[] args) {
		new GraphicsMastermindClient().play();
	}

}
