package usantatecla.mastermind.views.graphics;

import usantatecla.mastermind.models.Board;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
class ProposedCombinationsView extends JPanel {

    private final Board board;

    ProposedCombinationsView(Board game) {
        this.board = game;
        this.setLayout(new GridBagLayout());
    }

    void add() {
        int attempts = this.board.getAttempts();
        this.add(new AttemptsView(attempts), new Constraints(0, attempts, 1, 1));
        this.add(new ProposedCombinationView(this.board.getProposedCombinationColors(attempts - 1)), new Constraints(1, attempts, 1, 1));
        this.add(new ResultView(this.board.getResult(attempts - 1)), new Constraints(2, attempts, 1, 1));
    }
}
