package usantatecla.mastermind;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.views.console.ConsoleView;

class ConsoleMastermind extends Mastermind {

    @Override
    protected ConsoleView createView(StartController startController, PlayController playController,
                              ResumeController resumeController) {
        return new ConsoleView(startController, playController, resumeController);
    }

    public static void main(String[] args) {
        new ConsoleMastermind().play();
    }
    
}
