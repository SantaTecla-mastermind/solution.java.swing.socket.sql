package usantatecla.mastermind.views.graphics;

import javax.swing.JLabel;

import usantatecla.mastermind.models.Result;
import usantatecla.mastermind.views.MessageView;

@SuppressWarnings("serial")
class ResultView extends JLabel {
	
	private Result result;

	ResultView(Result result) {
		this.result = result;
		this.setText(MessageView.RESULT.getMessage().replaceFirst("#blacks", "" + this.result.getBlacks())
				.replaceFirst("#whites", "" + this.result.getWhites()));
	}

}
