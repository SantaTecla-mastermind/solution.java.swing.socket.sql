package usantatecla.mastermind.views.graphics;

import usantatecla.mastermind.controllers.Controller;
import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.views.View;

public class GraphicsView extends View {

	private GameView gameView;

	public GraphicsView() {
		this.gameView = new GameView();
	}

	@Override
	public void interact(Controller controller) {
		if (controller instanceof StartController) {
			this.gameView.interact((StartController) controller);
		} else {
			if (controller instanceof ProposalController) {
				this.gameView.interact((ProposalController) controller);
			} else {
				ResumeDialog resumeDialog = new ResumeDialog();
				((ResumeController) controller).resume(resumeDialog.isNewGame());
				if (resumeDialog.isNewGame()) {
					this.gameView = new GameView();
				} else {
					this.gameView.setVisible(false);
					System.exit(0);
				}
			}
		}
	}

}
