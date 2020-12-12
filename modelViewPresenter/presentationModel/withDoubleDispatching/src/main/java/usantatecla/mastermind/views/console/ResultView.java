package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.Console;

public class ResultView {
	
	private ProposalController proposalController;
	
	public ResultView(ProposalController proposalController){
		this.proposalController = proposalController;
	}

	public void writeln(int i) {
		Console.getInstance().writeln(Message.RESULT.getMessage()
				.replaceFirst("#blacks", "" + this.proposalController.getBlacks(i))
				.replaceFirst("#whites", "" + this.proposalController.getWhites(i)));
	}

}
