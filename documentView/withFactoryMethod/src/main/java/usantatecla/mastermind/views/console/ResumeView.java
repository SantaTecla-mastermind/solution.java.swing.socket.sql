package usantatecla.mastermind.views.console;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.Message;
import usantatecla.mastermind.views.WithBoardView;
import usantatecla.utils.views.YesNoDialog;

class ResumeView extends WithBoardView {

    ResumeView(Board board) {
        super(board);
    }

    boolean interact() {
        YesNoDialog yesNoDialog = new YesNoDialog();
        yesNoDialog.read(Message.RESUME.toString());
        if (yesNoDialog.isAffirmative()) {
            this.board.reset();
        }
        return yesNoDialog.isAffirmative();
    }

}
