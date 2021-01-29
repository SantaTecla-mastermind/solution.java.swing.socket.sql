package usantatecla.mastermind;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.graphics.GraphicsView;

class GraphicsMastermind {

    private Board board;
    private GraphicsView graphicsView;

    private GraphicsMastermind() {
        this.board = new Board();
        this.graphicsView = new GraphicsView(this.board);
    }

    private void play() {
        this.graphicsView.interact();
    }

    public static void main(String[] args) {
        new GraphicsMastermind().play();
    }

}
