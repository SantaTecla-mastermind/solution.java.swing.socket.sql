package usantatecla.mastermind.views.graphics;

import javax.swing.JOptionPane;

import usantatecla.mastermind.views.MessageView;

class ResumeDialog {

	private boolean newGame;
	
	ResumeDialog() {
		this.newGame = (JOptionPane.showConfirmDialog(null, MessageView.RESUME.getMessage(), MessageView.TITLE.getMessage(),
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
	}
	
	boolean isNewGame() {
		return this.newGame;
	}

}
