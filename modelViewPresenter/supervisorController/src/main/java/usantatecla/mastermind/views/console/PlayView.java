package usantatecla.mastermind.views.console;

import usantatecla.mastermind.views.Message;

public class PlayView implements usantatecla.mastermind.views.PlayView {

    public void writeWinner(){
        new MessageView().writeln(Message.WINNER);
    }

    public void writeLooser(){
        new MessageView().writeln(Message.LOOSER);
    }

}
