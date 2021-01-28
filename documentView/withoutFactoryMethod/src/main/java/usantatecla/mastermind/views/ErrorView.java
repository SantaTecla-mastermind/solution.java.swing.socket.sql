package usantatecla.mastermind.views;

import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

public abstract class ErrorView { // TODO abstract innecesario?

    public static final String[] MESSAGES = {
            "Repeated colors",
            "Wrong colors, they must be: " + Color.getAllInitials(),
            "Wrong proposed combination length"};

    public abstract void writeln(Error error); // TODO abstract innecesario?

}
