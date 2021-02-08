package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.models.ProposedCombination;

public abstract class ViewFactory {

    public abstract BoardView createBoardView(Board board);
    public abstract ProposedCombinationView createProposedCombinationView(ProposedCombination proposedCombination);
    public abstract ProposedCombinationView createProposedCombinationView();
    public abstract StartView createStartView();
    public abstract PlayView createPlayView();
    public abstract ResumeView createResumeView();
}
