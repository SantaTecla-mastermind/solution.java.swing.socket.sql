package usantatecla.mastermind.views.console;

import usantatecla.mastermind.views.Message;

public class PlayView implements usantatecla.mastermind.views.PlayView {

    public void writeWinner(){
        Message.WINNER.writeln();
    }

    public void writeLooser(){
        Message.LOOSER.writeln();
    }

}
