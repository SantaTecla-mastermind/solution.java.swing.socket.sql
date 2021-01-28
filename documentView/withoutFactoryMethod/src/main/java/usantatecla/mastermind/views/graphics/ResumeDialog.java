package usantatecla.mastermind.views.graphics;

import usantatecla.mastermind.views.Message;

import javax.swing.*;

class ResumeDialog {

    private final boolean newGame;

    ResumeDialog() {
        this.newGame = (JOptionPane.showConfirmDialog(null, Message.RESUME.toString(),
                Message.TITLE.toString(), JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }

    boolean isNewGame() {
        return this.newGame;
    }

}
