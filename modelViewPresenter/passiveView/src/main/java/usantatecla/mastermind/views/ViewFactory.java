package usantatecla.mastermind.views;

import usantatecla.mastermind.views.console.*;

public abstract class ViewFactory {

    public abstract BoardView createBoardView();
    public abstract ProposedCombinationView createProposedCombinationView();
    public abstract StartView createStartView();
    public abstract PlayView createPlayerView();
    public abstract ResumeView createResumeView();
}
