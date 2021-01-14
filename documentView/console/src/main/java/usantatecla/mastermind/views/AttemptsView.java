package usantatecla.mastermind.views;

//TODO Eliminar?
class AttemptsView {

    private int attempts;

    AttemptsView(int attempts) {
        this.attempts = attempts;
    }

    void writeln() {
        Message.ATTEMPTS.writeln(this.attempts);
    }
}