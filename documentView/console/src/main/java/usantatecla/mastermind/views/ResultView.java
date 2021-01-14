package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Result;
import usantatecla.utils.Console;

class ResultView {

    private Result result;

    ResultView(Result result) {
        this.result = result;
    }

    void writeln() {
        Message.RESULT.writeln(this.result.getBlacks(), this.result.getWhites());
    }

}
