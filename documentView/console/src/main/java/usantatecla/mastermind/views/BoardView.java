package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Game;
import usantatecla.utils.Console;

class BoardView extends WithGameView {

    BoardView(Game game) {
        super(game);
    }

    void write() {
        Console.getInstance().writeln();
        int attempts = this.game.getAttempts();
        new AttemptsView(attempts).writeln();
        new SecretCombinationView().writeln();
        for (int i = 0; i < attempts; i++) {
            new ProposedCombinationView(this.game.getProposedCombination(i)).write();
            new ResultView(this.game.getResult(i)).writeln();
        }
    }

}
