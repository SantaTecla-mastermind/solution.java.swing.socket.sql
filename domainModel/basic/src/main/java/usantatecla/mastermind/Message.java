package usantatecla.mastermind;

import usantatecla.utils.Console;

enum Message {
    
    ATTEMPTS("#attempts attempt(s): "),
    RESUME("Do you want to continue"),
    RESULT(" --> #blacks blacks and #whites whites"),
    PROPOSED_COMBINATION("Propose a combination: "),
    TITLE("----- MASTERMIND -----"),
    WINNER("You've won!!! ;-)"),
    LOOSER("You've lost!!! :-("),
    SECRET_COMBINATION("****");

    private String message;

    Message(String message) {
        this.message = message;
    }

    void write() {
        Console.getInstance().write(this.message);
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
    public String toString(){
        return this.message;
    }

}
