package usantatecla.mastermind;

import usantatecla.mastermind.views.graphics.GraphicsView;

class GraphicsMastermind extends Mastermind {

    @Override
    protected GraphicsView createView() {
        return new GraphicsView(this.startController, this.playController, this.resumeController);
    }

    public static void main(String[] args) {
        new GraphicsMastermind().play();
    }
    
}
