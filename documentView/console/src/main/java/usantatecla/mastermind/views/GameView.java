package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Game;
import usantatecla.utils.Console;

class GameView extends WithGameView {

    private SecretCombinationView secretCombinationView;

    GameView(Game game) {
        super(game);
        this.secretCombinationView = new SecretCombinationView();
    }

    void write() {
        Console.getInstance().writeln();
        new AttemptsView(this.game.getAttempts()).writeln();
        this.secretCombinationView.writeln();
        for (int i = 0; i < this.game.getAttempts(); i++) {
            new ProposedCombinationView(this.game.getProposedCombination(i)).write();
            new ResultView(this.game.getResult(i)).writeln();
        }
    }

    boolean isWinnerOrLooser() {
        if (this.game.isWinner()) {
            Console.getInstance().writeln(Message.WINNER.getMessage());
            return true;
        } else if (this.game.isLooser()) {
            Console.getInstance().writeln(Message.LOOSER.getMessage());
            return true;
        }
        return false;
    }
}
