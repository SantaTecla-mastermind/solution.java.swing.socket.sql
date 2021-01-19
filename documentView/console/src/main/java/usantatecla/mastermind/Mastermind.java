package usantatecla.mastermind;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.View;

public class Mastermind {

	private Board board; //TODO ¿Quitar board y dejarlo como new Board dentro de View?
	private View view;

	private Mastermind() {
		this.board = new Board();
		this.view = new View(this.board);
	}

	private void play() {
		this.view.interact();
	}

	public static void main(String[] args) {
		new Mastermind().play();
	}

}
