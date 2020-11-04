package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Game;
import usantatecla.utils.Console;

class GameView {
    private Game game;

    private SecretCombinationView secretCombinationView;

    GameView(Game game) {
        this.game = game;
        this.secretCombinationView = new SecretCombinationView();
    }

    void write() {
        Console.getInstance().writeln();
        MessageView.ATTEMPTS.writeln(this.game.getAttempts());
        this.secretCombinationView.writeln();
        for (int i = 0; i < this.game.getAttempts(); i++) {
            new ProposedCombinationView(this.game.getProposedCombination(i)).write();
            new ResultView(this.game.getResult(i)).writeln();
        }
    }

    boolean isWinnerOrLooser() {
        if (this.game.isWinner()) {
            MessageView.WINNER.writeln();
            return true;
        } else if (this.game.isLooser()) {
            MessageView.LOOSER.writeln();
            return true;
        }
        return false;
    }
}
