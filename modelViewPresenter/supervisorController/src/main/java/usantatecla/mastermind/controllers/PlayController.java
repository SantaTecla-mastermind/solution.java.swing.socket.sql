package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.views.PlayView;
import usantatecla.mastermind.views.ViewFactory;
import usantatecla.mastermind.views.console.ProposedCombinationView;
import usantatecla.utils.views.Console;

import java.util.List;

public class PlayController extends Controller {

    public PlayController(Board board, ViewFactory viewFactory) {
        super(board, viewFactory);
    }

    public void control(){
        PlayView playView = this.viewFactory.createPlayView();
        do {
            //TODO Problema ya que la ProposedCombinationView tiene que crearse con la proposed combination
            this.add(this.viewFactory.createProposedCombinationView().read());
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

    //TODO Hacer un metodo read, pero quien se encarga de leer?
    private ProposedCombination read() {
        return null;
    }

    private boolean isFinished() {
        return this.board.isFinished();
    }

    private boolean isWinner() {
        return this.board.isWinner();
    }

}
