package usantatecla.mastermind;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.View;
import usantatecla.mastermind.views.console.ConsoleView;

class ConsoleMastermind extends Mastermind {

    @Override
    protected View createView(Board board) {
        return new ConsoleView(board);
    }

    public static void main(String[] args) {
        new ConsoleMastermind().play();
    }
    
}
