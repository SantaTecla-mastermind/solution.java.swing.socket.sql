package usantatecla.mastermind;

import usantatecla.mastermind.views.console.ConsoleViewFactory;

class ConsoleMastermind extends Mastermind{

    @Override
    protected ConsoleViewFactory createViewFactory() {
        return new ConsoleViewFactory();
    }

    public static void main(String[] args) {
        new ConsoleMastermind().play();
    }

}
