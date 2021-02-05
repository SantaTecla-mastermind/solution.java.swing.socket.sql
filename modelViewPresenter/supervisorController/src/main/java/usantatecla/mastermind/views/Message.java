package usantatecla.mastermind.views;

public enum Message {

    TITLE("----- MASTERMIND -----"),
    SECRET_COMBINATION("****"),
    ATTEMPTS("#attempts attempt(s): "),
    RESULT(" --> #blacks blacks and #whites whites"),
    PROPOSED_COMBINATION("Propose a combination: "),
    WINNER("You've won!!! ;-)"),
    LOOSER("You've lost!!! :-("),
    RESUME("Do you want to continue");

    private String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }

}
