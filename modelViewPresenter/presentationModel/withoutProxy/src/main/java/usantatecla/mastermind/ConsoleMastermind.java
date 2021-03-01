package usantatecla.mastermind;

import usantatecla.mastermind.views.console.ConsoleView;

class ConsoleMastermind extends Mastermind {

    @Override
    protected ConsoleView createView() {
        return new ConsoleView();
    }

    @Override
    protected Boolean isStandalone() {
        return true;
    }

    public static void main(String[] args) {
        new ConsoleMastermind().play();
    }
    
}
