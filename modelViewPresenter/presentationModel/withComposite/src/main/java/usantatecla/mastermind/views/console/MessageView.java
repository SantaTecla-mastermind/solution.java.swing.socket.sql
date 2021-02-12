package usantatecla.mastermind.views.console;

import usantatecla.mastermind.views.Message;
import usantatecla.utils.views.Console;

class MessageView {

    void writeln(Message message) {
        Console.getInstance().writeln(message.toString());
    }

    void writeln(Message message, int attempts) {
        assert message == Message.ATTEMPTS;

        Console.getInstance().writeln(message.toString().replaceAll("#attempts", "" + attempts));
    }

    void writeln(Message message, int blacks, int whites) {
        assert message == Message.RESULT;

        Console.getInstance().writeln(message.toString().replaceFirst("#blacks", "" + blacks).replaceFirst("#whites", "" + whites));
    }

}
