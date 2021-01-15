package usantatecla.mastermind.models;

import usantatecla.utils.ColorCode;

import java.util.ArrayList;
import java.util.List;

abstract class Combination {

    protected List<ColorCode> colorCodes;

    protected Combination() {
        this.colorCodes = new ArrayList<>();
    }

}
