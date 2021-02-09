package usantatecla.mastermind;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.console.ConsoleView;

class ConsoleMastermind extends Mastermind {

    @Override
    protected ConsoleView createView(Logic logic) {
        return new ConsoleView(logic);
    }

    public static void main(String[] args) {
        new ConsoleMastermind().play();
    }
    
}
