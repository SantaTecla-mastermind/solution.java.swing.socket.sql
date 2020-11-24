package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.Console;

class ResultView {

    private ProposalController proposalController;

    ResultView(ProposalController proposalController) {
        this.proposalController = proposalController;
    }

    void writeln(int position) {
        Console.getInstance().writeln(Message.RESULT.getMessage()
                .replaceFirst("#blacks", "" + this.proposalController.getResult(position).getBlacks())
                .replaceFirst("#whites", "" + this.proposalController.getResult(position).getWhites()));
    }

}
