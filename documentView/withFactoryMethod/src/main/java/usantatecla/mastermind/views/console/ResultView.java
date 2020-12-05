package usantatecla.mastermind.views.console;

import usantatecla.mastermind.models.Result;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.Console;

class ResultView {

    private Result result;

    ResultView(Result result) {
        this.result = result;
    }

    void writeln() {
        Console.getInstance().writeln(Message.RESULT.getMessage().replaceFirst("#blacks", "" + this.result.getBlacks())
                .replaceFirst("#whites", "" + this.result.getWhites()));
    }

}
