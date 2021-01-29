package usantatecla.mastermind;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.views.View;
import usantatecla.mastermind.views.console.ConsoleView;

class ConsoleMastermind extends Mastermind{

    @Override
    protected View createView(Logic logic) {
        return new ConsoleView(logic);
    }

    public static void main(String[] args) {
        new ConsoleMastermind().play();
    }
    
}
