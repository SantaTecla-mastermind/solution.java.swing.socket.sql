package usantatecla.mastermind.views.console;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.mastermind.views.ViewFactory;

public class ConsoleViewFactory extends ViewFactory {

    @Override
    public BoardView createBoardView(Board board) {
        return new BoardView(board);
    }

    @Override
    public ProposedCombinationView createProposedCombinationView(ProposedCombination proposedCombination) {
        return new ProposedCombinationView(proposedCombination);
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
}
