package usantatecla.mastermind.views.console;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.View;

public class ConsoleView extends View {

    private StartView startView;
    private PlayView playView;
    private ResumeView resumeView;

    public ConsoleView(Board board) {
        super(board);
        this.startView = new StartView(this.board);
        this.playView = new PlayView(this.board);
        this.resumeView = new ResumeView(this.board);
    }

    @Override
    protected void start() {
        this.startView.interact();
    }

    @Override
    protected void play() {
        this.playView.interact();
    }

    @Override
    protected boolean resume() {
        return this.resumeView.interact();
    }

}
