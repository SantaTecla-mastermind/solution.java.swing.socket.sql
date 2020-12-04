package usantatecla.mastermind.views.graphics;

import javax.swing.JLabel;

import usantatecla.mastermind.views.Message;

@SuppressWarnings("serial")
class AttemptsView extends JLabel {

    AttemptsView(int attempts) {
        this.setText(Message.ATTEMPTS.getMessage().replaceFirst("#attempts", "" + (attempts)));
    }

}
