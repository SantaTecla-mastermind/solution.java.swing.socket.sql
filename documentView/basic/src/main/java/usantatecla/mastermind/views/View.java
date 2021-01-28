package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Board;

public class View extends WithBoardView {

    private final StartView startView;
    private final PlayView playView;
    private final ResumeView resumeView;

    public View(Board board) {
        super(board);
        this.startView = new StartView(this.board);
        this.playView = new PlayView(this.board);
        this.resumeView = new ResumeView(this.board);
    }

    public void interact() {
        do {
            this.startView.interact();
            this.playView.interact();
        } while (this.resumeView.interact());
    }
}
