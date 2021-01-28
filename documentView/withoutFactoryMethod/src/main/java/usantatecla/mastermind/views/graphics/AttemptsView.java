package usantatecla.mastermind.views.graphics;

import usantatecla.mastermind.views.Message;

import javax.swing.*;

@SuppressWarnings("serial")
class AttemptsView extends JLabel {

    AttemptsView(int attempts) {
        this.setText(Message.ATTEMPTS.toString().replaceFirst("#attempts", "" + (attempts)));
    }

}
