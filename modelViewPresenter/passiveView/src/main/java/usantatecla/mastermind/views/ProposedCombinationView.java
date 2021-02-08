package usantatecla.mastermind.views;

import usantatecla.mastermind.types.Color;

import java.util.List;

public interface ProposedCombinationView {

    List<Color> read();
    void write(List<Color> colors);

}
