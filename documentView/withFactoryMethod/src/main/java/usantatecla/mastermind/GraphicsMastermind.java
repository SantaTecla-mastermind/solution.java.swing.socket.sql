package usantatecla.mastermind;

import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.views.View;
import usantatecla.mastermind.views.graphics.GraphicsView;

public class GraphicsMastermind extends Mastermind{

	@Override
	protected View createView(Game game) {
		return new GraphicsView(game);
	}
	
	public static void main(String[] args) {
		new GraphicsMastermind().play();
	}
}
