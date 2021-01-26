package usantatecla.mastermind.views.graphics;

import javax.swing.JOptionPane;

import usantatecla.mastermind.views.Message;

class ResumeDialog {

    private boolean newGame;

    ResumeDialog() {
        this.newGame = (JOptionPane.showConfirmDialog(null, Message.RESUME.toString(),
                Message.TITLE.toString(), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }

    boolean isNewGame() {
        return this.newGame;
    }

}
