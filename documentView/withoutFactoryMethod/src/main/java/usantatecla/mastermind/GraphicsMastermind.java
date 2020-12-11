package usantatecla.mastermind;

import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.views.graphics.GraphicsView;

public class GraphicsMastermind {

    private final GraphicsView graphicsView;

    private GraphicsMastermind() {
        this.graphicsView = new GraphicsView(new Game());
    }

    private void play() {
        this.graphicsView.interact();
    }

    public static void main(String[] args) {
        new GraphicsMastermind().play();
    }
}
