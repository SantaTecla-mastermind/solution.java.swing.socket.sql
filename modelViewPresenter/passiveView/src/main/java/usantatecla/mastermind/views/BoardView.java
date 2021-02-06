package usantatecla.mastermind.views;

import usantatecla.mastermind.types.Color;

import java.util.ArrayList;
import java.util.List;

public abstract class BoardView {

    protected int attempts;
    protected List<List<Color>> proposedCombinationColors;
    protected List<Integer> blacks;
    protected List<Integer> whites;

    public BoardView(){
        this.proposedCombinationColors = new ArrayList<>();
        this.blacks = new ArrayList<>();
        this.whites = new ArrayList<>();
    }

    public void setAttempts(int attempts){
        this.attempts = attempts;
    }

    public void setProposedCombinationColors(List<Color> proposedCombinationColors){
        this.proposedCombinationColors.add(proposedCombinationColors);
    }

    public void setBlacks(int blacks){
        this.blacks.add(blacks);
    }

    public void setWhites(int whites){
        this.whites.add(whites);
    }

    public abstract void write();

}
