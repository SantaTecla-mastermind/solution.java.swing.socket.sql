package usantatecla.mastermind.views;

import usantatecla.mastermind.types.Color;

import java.util.List;

public interface ProposedCombinationView {

    String read();
    void write(List<Color> colors);

}
