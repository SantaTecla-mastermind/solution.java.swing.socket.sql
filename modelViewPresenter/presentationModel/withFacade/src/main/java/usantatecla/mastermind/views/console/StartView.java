package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.views.Message;

public class StartView  {

    private Logic logic;

    StartView(Logic logic) {
        this.logic = logic;
    }

    void interact() {
        Message.TITLE.writeln();
        new BoardView().write(this.logic);
    }

}
