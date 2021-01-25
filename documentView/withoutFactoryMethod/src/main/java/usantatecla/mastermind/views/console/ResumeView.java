package usantatecla.mastermind.views.console;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.Message;
import usantatecla.mastermind.views.WithBoardView;
import usantatecla.utils.views.YesNoDialog;

public class ResumeView extends WithBoardView {

    public ResumeView(Board board) {
        super(board);
    }

    public boolean interact() {
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(Message.RESUME.toString());
        if (yesNoDialog.isAffirmative()) {
            this.board.reset();
        }
        return yesNoDialog.isAffirmative();
    }

}
