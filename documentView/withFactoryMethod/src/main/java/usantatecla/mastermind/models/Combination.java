package usantatecla.mastermind.models;

import usantatecla.mastermind.types.Color;

import java.util.ArrayList;
import java.util.List;

abstract class Combination {

    protected List<Color> colors;

    protected Combination() {
        this.colors = new ArrayList<>();
    }

}
