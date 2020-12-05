package usantatecla.mastermind.views.graphics;

import usantatecla.mastermind.models.Game;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
class ProposedCombinationsView extends JPanel {

    private Game game;

    ProposedCombinationsView(Game game) {
        this.game = game;
        this.setLayout(new GridBagLayout());
    }

    void add() {
        int attempts = this.game.getAttempts();
        this.add(new AttemptsView(attempts), new Constraints(0, attempts, 1, 1));
        this.add(new ProposedCombinationView(this.game.getProposedCombination(attempts - 1)), new Constraints(1, attempts, 1, 1));
        this.add(new ResultView(this.game.getResult(attempts - 1)), new Constraints(2, attempts, 1, 1));
    }
}
