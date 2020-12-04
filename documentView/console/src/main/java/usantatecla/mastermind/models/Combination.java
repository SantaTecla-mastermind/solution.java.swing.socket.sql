package usantatecla.mastermind.models;

import usantatecla.mastermind.types.Color;

import java.util.ArrayList;
import java.util.List;

public abstract class Combination {

    private static final int WIDTH = 4;

    List<Color> colors;

    protected Combination() {
        this.colors = new ArrayList<>();
    }

    public static int getWidth() {
        return Combination.WIDTH;
    }

}
