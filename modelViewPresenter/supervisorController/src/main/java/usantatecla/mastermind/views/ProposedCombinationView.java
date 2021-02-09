package usantatecla.mastermind.views;

import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.mastermind.types.Color;

import java.util.List;

public interface ProposedCombinationView {

    ProposedCombination read();
    void write();

}
