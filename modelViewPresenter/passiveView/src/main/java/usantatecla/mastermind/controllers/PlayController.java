package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.views.ViewFactory;
import usantatecla.mastermind.views.console.PlayView;
import usantatecla.mastermind.views.console.ProposedCombinationView;

import java.util.List;

public class PlayController extends Controller {

    public PlayController(Board board, ViewFactory viewFactory) {
        super(board, viewFactory);
    }

    public void control(){
        PlayView playView = new PlayView();
        do {
            this.add(new ProposedCombinationView().read());
            this.writeBoard();
        } while (!this.isFinished());
        if(this.isWinner()){
            playView.writeWinner();
        } else {
            playView.writeLooser();
        }
    }

    private void add(List<Color> colors) {
        this.board.add(colors);
    }

    private boolean isFinished() {
        return this.board.isFinished();
    }

    private boolean isWinner() {
        return this.board.isWinner();
    }

}
