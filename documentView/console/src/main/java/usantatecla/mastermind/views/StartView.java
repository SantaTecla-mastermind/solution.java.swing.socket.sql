package usantatecla.mastermind.views;

class StartView {

    void interact() {
        Message.TITLE.writeln();
        new SecretCombinationView().writeln();
    }

}
