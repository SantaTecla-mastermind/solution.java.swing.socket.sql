package usantatecla.mastermind.views.graphics;

import usantatecla.mastermind.models.Result;
import usantatecla.mastermind.views.Message;

import javax.swing.*;

@SuppressWarnings("serial")
class ResultView extends JLabel {

    private Result result;

    ResultView(Result result) {
        this.result = result;
        this.setText(Message.RESULT.getMessage().replaceFirst("#blacks", "" + this.result.getBlacks())
                .replaceFirst("#whites", "" + this.result.getWhites()));
    }

}
