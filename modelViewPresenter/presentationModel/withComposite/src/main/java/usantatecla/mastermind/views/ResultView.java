package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.utils.Console;

class ResultView {
	
	private PlayController playController;
	
	ResultView(PlayController playController){
		this.playController = playController;
	}

	void writeln(int position) {
		Console.getInstance().writeln(Message.RESULT.getMessage()
				.replaceFirst("#blacks", "" + this.playController.getBlacks(position))
				.replaceFirst("#whites", "" + this.playController.getWhites(position)));
	}

}
