package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Board;

public abstract class ViewFactory {

    public abstract BoardView createBoardView(Board board);
    public abstract ProposedCombinationView createProposedCombinationView();
    public abstract StartView createStartView();
    public abstract PlayView createPlayView();
    public abstract ResumeView createResumeView();
    public abstract ErrorView createErrorView();

}
