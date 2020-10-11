package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Result;
import usantatecla.mastermind.views.ResultView;

class ResultController {
	
	private Result result;
	
	private ResultView resultView;

	ResultController(Result result) {
		this.result = result;
		this.resultView = new ResultView(this.result);
	}

	ResultView getResultView() {
		return this.resultView;
	}
	
	Result getResult() {
		return this.result;
	}

}
