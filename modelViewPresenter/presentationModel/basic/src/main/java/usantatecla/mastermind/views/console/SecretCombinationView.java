package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Controller;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.Console;

class SecretCombinationView {

    private Controller controller;

    SecretCombinationView(Controller controller) {
        this.controller = controller;
    }

    void writeln() {
        for (int i = 0; i < controller.getWidth(); i++) {
            Console.getInstance().write(Message.SECRET.getMessage());
        }
        Console.getInstance().writeln();
    }

}
