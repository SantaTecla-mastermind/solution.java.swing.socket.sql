package usantatecla.mastermind;

import usantatecla.utils.YesNoDialog;

public class Mastermind {

	private Board board;
	
	public void play() {
		do {
			this.playGame();
		} while (this.isResumedGame());
	}

	private void playGame(){
		Message.TITLE.writeln();
		this.board = new Board();
		this.board.writeln();
		do {
			ProposedCombination proposedCombination = new ProposedCombination();
			proposedCombination.read();
			this.board.add(proposedCombination);
			this.board.writeln();
		} while (!this.board.isFinished());
		Message message = Message.LOOSER;
		if (this.board.isWinner()){
			message = Message.WINNER;
		}
		message.writeln();
	}

	private boolean isResumedGame() {
		return new YesNoDialog().read(Message.RESUME.toString());
	}

	public static void main(String[] args) {
		new Mastermind().play();
	}

}
