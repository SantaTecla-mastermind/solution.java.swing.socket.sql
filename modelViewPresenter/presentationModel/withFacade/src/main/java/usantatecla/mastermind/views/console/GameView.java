package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.views.Message;
import usantatecla.mastermind.views.WithLogicView;
import usantatecla.utils.Console;

class GameView extends WithLogicView {

    private ProposedCombinationView proposedCombinationView;
    private SecretCombinationView secretCombinationView;
    private ResultView resultView;

    GameView(Logic logic, ProposedCombinationView proposedCombinationView) {
        super(logic);
        this.proposedCombinationView = proposedCombinationView;
        this.secretCombinationView = new SecretCombinationView(this.logic);
        this.resultView = new ResultView(this.logic);
    }

    void write() {
        Console.getInstance().writeln();
        new AttemptsView(this.logic).writeln();
        this.secretCombinationView.writeln();
        for (int i = 0; i < this.logic.getAttempts(); i++) {
            this.proposedCombinationView.write(i);
            this.resultView.writeln(i);
        }
    }

    boolean isWinnerOrLooser() {
        if (this.logic.isWinner()) {
            Console.getInstance().writeln(Message.WINNER.getMessage());
            return true;
        } else if (this.logic.isLooser()) {
            Console.getInstance().writeln(Message.LOOSER.getMessage());
            return true;
        }
        return false;
    }
}
