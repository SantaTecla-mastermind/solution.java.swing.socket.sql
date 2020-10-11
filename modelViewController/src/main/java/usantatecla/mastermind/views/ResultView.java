package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Result;

public class ResultView {

	private Result result;

	public ResultView(Result result) {
		this.result = result;
	}

	void writeln() {
		MessageView.RESULT.writeln(this.result.getBlacks(), this.result.getWhites());
	}

}
