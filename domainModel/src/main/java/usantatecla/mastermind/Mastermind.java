package usantatecla.mastermind;

import usantatecla.utils.YesNoDialog;

public class Mastermind {

    private Board board;

    Mastermind() {
        this.board = new Board();
    }

    private void play() {
        do {
            this.playGame();
        } while (this.isResumedGame());
    }

    private void playGame() {
        Message.TITLE.writeln();
        this.board.write();
        do {
            this.playTurn();
            this.board.write(); // TODO Revisar writeln y cambiar a write o a writeln en TicTacToe
        } while (!this.board.isFinished());
        this.write();
    }

    private void playTurn() {
        ProposedCombination proposedCombination = new ProposedCombination();
        proposedCombination.read();
        this.board.add(proposedCombination);
    }

    private void write() {
        Message message = Message.LOOSER;
        if (this.board.isWinner()) {
            message = Message.WINNER;
        }
        message.writeln();

        // TODO ¿Operador ternario para reducir?
        // (this.board.isWinner() ? Message.WINNER : Message.LOOSER).writeln();
    }

    private boolean isResumedGame() {
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(Message.RESUME.toString());
        if (yesNoDialog.isAffirmative()) {
            this.board.reset();
        }
        return yesNoDialog.isAffirmative();
    }

    public static void main(String[] args) {
        new Mastermind().play();
    }

}
