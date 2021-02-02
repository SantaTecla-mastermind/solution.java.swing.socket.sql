package usantatecla.mastermind.views.console;

import usantatecla.mastermind.views.Message;
import usantatecla.utils.views.Console;

public class BoardView {

    public void writeln(){
        Console.getInstance().writeln();
    }

    public void writeAttempts(int attempts){
        Message.ATTEMPTS.writeln(attempts);
    }

    public void writeSecretCombination(){
        Message.SECRET_COMBINATION.writeln();
    }

    public void writeResult(int blacks, int whites){
        Message.RESULT.writeln(blacks, whites);
    }

}
