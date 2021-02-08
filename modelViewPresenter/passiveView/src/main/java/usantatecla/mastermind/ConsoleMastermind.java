package usantatecla.mastermind;

import usantatecla.mastermind.views.ViewFactory;
import usantatecla.mastermind.views.console.ConsoleViewFactory;

class ConsoleMastermind extends Mastermind {

    @Override
    protected ViewFactory createViewFactory() {
        return new ConsoleViewFactory();
    }

    public static void main(String[] args) {
        new ConsoleMastermind().play();
    }

}
