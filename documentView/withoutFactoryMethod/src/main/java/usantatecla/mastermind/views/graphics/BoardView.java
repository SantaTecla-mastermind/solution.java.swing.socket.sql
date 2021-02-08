package usantatecla.mastermind.views.graphics;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.views.Message;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
class BoardView extends JFrame {

    private static final String GAME_OVER = "Game Over";
    private final Board board;
    private SecretCombinationView secretCombinationView;
    private ProposedCombinationsView proposedCombinationsView;
    private ProposalCombinationView proposalCombinationView;

    BoardView(Board board) {
        super(Message.TITLE.toString());
        this.board = board;
        this.getContentPane().setLayout(new GridBagLayout());
        this.setSize(400, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    void start() {
        this.clear();
        this.secretCombinationView = new SecretCombinationView();
        this.getContentPane().add(this.secretCombinationView, new Constraints(0, 0, 3, 1));
        this.proposedCombinationsView = new ProposedCombinationsView(this.board);
        this.getContentPane().add(this.proposedCombinationsView, new Constraints(0, 1, 3, 10));
        this.proposalCombinationView = new ProposalCombinationView(this.getRootPane());
        this.getContentPane().add(this.proposalCombinationView, new Constraints(0, 11, 3, 1));
        this.setVisible(true);
    }

    void play() {
        List<Color> colors = new ArrayList<>();
        ProposedCombinationView proposedCombinationView = new ProposedCombinationView(colors);
        do {
            System.out.println();
            if (this.proposalCombinationView.getCharacters() != null) {
                proposedCombinationView.read(this.proposalCombinationView.getCharacters());
                if (!proposedCombinationView.isOk()) {
                    this.proposalCombinationView.resetCharacters();
                }
            }
        } while (this.proposalCombinationView.getCharacters() == null);
        this.board.add(colors);
        this.proposalCombinationView.resetCharacters();
        this.proposedCombinationsView.add();
        this.setVisible(true);
    }

    void drawGameOver() {
        if (this.board.isFinished()) {
            String message = "";
            if (this.board.isWinner()) {
                message = Message.WINNER.toString();
            } else {
                message = Message.LOOSER.toString();
            }
            JOptionPane.showMessageDialog(null, message, BoardView.GAME_OVER, JOptionPane.WARNING_MESSAGE);
        }
    }

    private void clear() {
        if (this.secretCombinationView != null) {
            this.secretCombinationView.removeAll();
        }
        if (this.proposedCombinationsView != null) {
            this.proposedCombinationsView.removeAll();
        }
    }

}
