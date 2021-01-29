package usantatecla.mastermind.views;

import usantatecla.utils.views.Console;

enum Message {

    TITLE("----- MASTERMIND -----"),
    SECRET_COMBINATION("****"),
    ATTEMPTS("#attempts attempt(s): "),
    RESULT(" --> #blacks blacks and #whites whites"),
    PROPOSED_COMBINATION("Propose a combination: "),
    WINNER("You've won!!! ;-)"),
    LOOSER("You've lost!!! :-("),
    RESUME("Do you want to continue");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    void writeln() {
        Console.getInstance().writeln(this.message);
    }

    void writeln(int attempts) {
        assert this == Message.ATTEMPTS;

        Console.getInstance().writeln(this.message.replaceAll("#attempts", "" + attempts));
    }

    void writeln(int blacks, int whites) {
        assert this == Message.RESULT;

        Console.getInstance().writeln(this.message.replaceFirst("#blacks", "" + blacks).replaceFirst("#whites", "" + whites));
    }

    @Override
    public String toString() {
        return this.message;
    }

}
