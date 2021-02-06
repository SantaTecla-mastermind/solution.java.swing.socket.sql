package usantatecla.mastermind.views.console;

import usantatecla.mastermind.views.ViewFactory;

public class ConsoleViewFactory extends ViewFactory {

    @Override
    public BoardView createBoardView() {
        return new BoardView();
    }

    @Override
    public ProposedCombinationView createProposedCombinationView() {
        return new ProposedCombinationView();
    }

    @Override
    public StartView createStartView() {
        return new StartView();
    }

    @Override
    public PlayView createPlayView() {
        return new PlayView();
    }

    @Override
    public ResumeView createResumeView() {
        return new ResumeView();
    }

    @Override
    public ErrorView createErrorView() {
        return new ErrorView();
    }

}
