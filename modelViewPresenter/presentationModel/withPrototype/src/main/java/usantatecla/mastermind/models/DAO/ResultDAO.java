package usantatecla.mastermind.models.DAO;

import usantatecla.mastermind.models.Result;

public class ResultDAO {

	protected Result result;

	protected ResultDAO(Result result) {
		this.result = result;
	}
	
	public Result getResult() {
		return this.result;
	}

}
