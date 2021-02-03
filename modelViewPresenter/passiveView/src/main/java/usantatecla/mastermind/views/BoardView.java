package usantatecla.mastermind.views;

import usantatecla.mastermind.types.Color;

import java.util.List;

public abstract class BoardView {

    protected int attempts;
    protected List<Color> proposedCombinationColors;
    protected int blacks;
    protected int whites;

    public void setAttempts(int attempts){
        this.attempts = attempts;
    }

    public void setProposedCombinationColors(List<Color> proposedCombinationColors){
        //assert this.proposedCombinationColors.size() < Result.WIDTH;

        this.proposedCombinationColors = proposedCombinationColors;
    }

    public void setBlacks(int blacks){
        this.blacks = blacks;
    }

    public void setWhites(int whites){
        this.whites = whites;
    }

    public abstract void write();

}
