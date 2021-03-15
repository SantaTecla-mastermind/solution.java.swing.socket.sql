package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Board;

public class View extends WithBoardView {

    private StartView startView;
    private PlayView playView;
    private ResumeView resumeView;

    public View(Board board) {
        super(board);
        this.startView = new StartView(this.board);
        this.playView = new PlayView(this.board);
        this.resumeView = new ResumeView(this.board);
    }

    public void start() {
        this.startView.interact();
    }

    public void play() {
        this.playView.interact();
    }

    public boolean resume() {
        return this.resumeView.interact();
    }

}
