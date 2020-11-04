package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Result;

class ResultView {
	
	private Result result;

	ResultView(Result result) {
		this.result = result;
	}

	void writeln() {
		MessageView.RESULT.writeln(this.result.getBlacks(), this.result.getWhites());
	}

}
