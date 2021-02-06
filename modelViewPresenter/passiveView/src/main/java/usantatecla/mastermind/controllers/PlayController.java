package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.mastermind.views.ViewFactory;

import java.util.List;

public class PlayController extends Controller {

    public PlayController(Board board, ViewFactory viewFactory) {
        super(board, viewFactory);
    }

    public void control(){
        do {
            this.board.add(this.readProposedCombination());
            this.writeBoard();
        } while (!this.board.isFinished());
        if (this.board.isWinner()){
            this.viewFactory.createPlayView().writeWinner();
        } else {
            this.viewFactory.createPlayView().writeLooser();
        }
    }

    // TODO Añadido método privado por métricas ajustadas y legibilidad
    private List<Color> readProposedCombination() {
        Error error;
        List<Color> colors;
        do {
            String characters = this.viewFactory.createProposedCombinationView().read();
            colors = Color.get(characters);
            error = ProposedCombination.getError(colors);
            this.viewFactory.createErrorView().writeln(error);
        } while (!error.isNull());
        return colors;
    }

}
