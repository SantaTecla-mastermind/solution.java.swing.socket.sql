package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Board;
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
