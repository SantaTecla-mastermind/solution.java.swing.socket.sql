package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.Message;

public class StartView  {

    private Logic logic;

    StartView(Logic logic) {
        this.logic = logic;
    }

    void interact() {
        new MessageView().writeln(Message.TITLE);
        new BoardView().write(this.logic);
    }

}
