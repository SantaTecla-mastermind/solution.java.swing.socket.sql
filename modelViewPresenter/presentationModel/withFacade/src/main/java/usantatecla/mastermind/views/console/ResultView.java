package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.Message;
import usantatecla.mastermind.views.WithLogicView;
import usantatecla.utils.Console;

class ResultView extends WithLogicView {

    ResultView(Logic logic) {
        super(logic);
    }

    void writeln(int i) {
        Console.getInstance().writeln(Message.RESULT.getMessage()
                .replaceFirst("#blacks", "" + this.logic.getBlacks(i))
                .replaceFirst("#whites", "" + this.logic.getWhites(i)));
    }

}
