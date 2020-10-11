package usantatecla.mastermind.views.graphics;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.controllers.StartController;
import usantatecla.mastermind.views.View;

public class GraphicsView extends View {

	private GameView gameView;

	public GraphicsView(StartController startController, ProposalController proposalController,
			ResumeController resumeController) {
		super(startController, proposalController, resumeController);
		this.gameView = new GameView(startController, proposalController);
	}

	@Override
	protected void start() {
		this.gameView.start();
	}

	@Override
	protected boolean propose() {
		return this.gameView.propose();
	}

	@Override
	protected boolean isNewGame() {
		ResumeDialog resumeDialog = new ResumeDialog();
		if (resumeDialog.isNewGame()) {
			this.resumeController.clearGame();
			this.gameView = new GameView(this.startController, this.proposalController);
			return true;
		} else {
			this.gameView.setVisible(false);
			System.exit(0);
			return false;
		}
	}

}
