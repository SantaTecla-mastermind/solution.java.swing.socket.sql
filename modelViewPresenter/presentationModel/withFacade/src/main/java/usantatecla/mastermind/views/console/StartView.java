package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.views.Message;
import usantatecla.mastermind.views.WithLogicView;

class StartView extends WithLogicView {

    StartView(Logic logic) {
        super(logic);
    }

    void interact() {
        new MessageView().writeln(Message.TITLE);
        new BoardView().write(this.logic);
    }

}
