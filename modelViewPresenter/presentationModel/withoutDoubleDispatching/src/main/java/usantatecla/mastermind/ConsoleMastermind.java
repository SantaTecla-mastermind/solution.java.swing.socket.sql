package usantatecla.mastermind;

import usantatecla.mastermind.views.View;
import usantatecla.mastermind.views.console.ConsoleView;

class ConsoleMastermind extends Mastermind{

    @Override
    protected View createView() {
        return new ConsoleView();
    }

    public static void main(String[] args) {
        new ConsoleMastermind().play();
    }
    
}
