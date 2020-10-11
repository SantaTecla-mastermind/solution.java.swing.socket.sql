package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.PlayController;

class ResultView {
	
	private PlayController playController;
	
	ResultView(PlayController playController){
		this.playController = playController;
	}

	void writeln(int position) {
		MessageView.RESULT.writeln(this.playController.getBlacks(position),this.playController.getWhites(position));
	}

}
