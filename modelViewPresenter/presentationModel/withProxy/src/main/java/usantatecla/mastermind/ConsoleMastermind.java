package usantatecla.mastermind;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.controllers.implementation.LogicImplementation;
import usantatecla.mastermind.views.console.ConsoleView;

class ConsoleMastermind extends Mastermind {

    @Override
    protected ConsoleView createView() {
        return new ConsoleView();
    }

    @Override
    protected Logic createLogic() {
        return new LogicImplementation();
    }

    public static void main(String[] args) {
        new ConsoleMastermind().play();
    }
    
}
