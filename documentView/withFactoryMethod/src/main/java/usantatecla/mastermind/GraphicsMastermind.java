package usantatecla.mastermind;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.View;
import usantatecla.mastermind.views.graphics.GraphicsView;

class GraphicsMastermind extends Mastermind {

    @Override
    protected View createView(Board board) {
        return new GraphicsView(board);
    }

    public static void main(String[] args) {
        new GraphicsMastermind().play();
    }
    
}
