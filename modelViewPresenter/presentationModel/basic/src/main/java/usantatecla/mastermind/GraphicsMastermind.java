package usantatecla.mastermind;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.View;
import usantatecla.mastermind.views.graphics.GraphicsView;

public class GraphicsMastermind extends Mastermind{

    @Override
    protected View createView(StartController startController, PlayController playController,
                              ResumeController resumeController) {
        return new GraphicsView(startController, playController, resumeController);
    }

    public static void main(String[] args) {
        new GraphicsMastermind().play();
    }
    
}
