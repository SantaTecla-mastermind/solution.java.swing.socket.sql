package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.View;

public class ConsoleView extends View {

    private StartView startView;
    private PlayView playView;
    private ResumeView resumeView;

    public ConsoleView(Logic logic) {
        super(logic);
        this.startView = new StartView(this.logic);
        this.playView = new PlayView(this.logic);
        this.resumeView = new ResumeView(this.logic);
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
