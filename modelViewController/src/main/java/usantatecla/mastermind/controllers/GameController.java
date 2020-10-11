package usantatecla.mastermind.controllers;

import java.util.ArrayList;
import java.util.List;

import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.mastermind.models.Result;
import usantatecla.mastermind.views.GameView;
import usantatecla.mastermind.views.ProposedCombinationView;
import usantatecla.mastermind.views.ResultView;

class GameController {

	private GameView gameView;

	private Game game;

	GameController() {
		SecretCombinationController secretCombinationController = new SecretCombinationController();
		this.game = new Game(secretCombinationController.getSecretCombination());
		this.gameView = new GameView(this.game, secretCombinationController.getSecretCombinationView());
		this.game.addObserver(this.gameView);
	}

	void proposeCombination() {
		ProposedCombinationController proposecombinationController = new ProposedCombinationController();
		proposecombinationController.proposeCombination();
		this.gameView.addProposedCombinationView(proposecombinationController.getProposeCombinationView());
		this.game.addProposedCombination(proposecombinationController.getProposeCombination());
		ResultController resultController = new ResultController(this.game.getResult());
		this.gameView.addResultView(resultController.getResultView());
		this.game.addResult(resultController.getResult());
	}

	Game getGame() {
		return this.game;
	}

	void reset() {
		List<ProposedCombinationView> proposedCombinationViews = new ArrayList<ProposedCombinationView>();
		for (ProposedCombination proposedCombination : this.game.getProposedCombinations()) {
			ProposedCombinationController proposedCombinationController = new ProposedCombinationController(
					proposedCombination);
			proposedCombinationViews.add(proposedCombinationController.getProposeCombinationView());
		}
		List<ResultView> resultViews = new ArrayList<ResultView>();
		for (Result result : this.game.getResults()) {
			ResultController resultController = new ResultController(result);
			resultViews.add(resultController.getResultView());
		}
		this.gameView.reset(proposedCombinationViews, resultViews);
	}

}
