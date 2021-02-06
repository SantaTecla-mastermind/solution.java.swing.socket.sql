package usantatecla.mastermind.views;

public abstract class ViewFactory {

    public abstract BoardView createBoardView();
    public abstract ProposedCombinationView createProposedCombinationView();
    public abstract StartView createStartView();
    public abstract PlayView createPlayView();
    public abstract ResumeView createResumeView();
    public abstract ErrorView createErrorView();

}
