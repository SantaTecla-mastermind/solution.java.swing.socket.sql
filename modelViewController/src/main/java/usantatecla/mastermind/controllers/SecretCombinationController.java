package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.SecretCombination;
import usantatecla.mastermind.views.SecretCombinationView;

class SecretCombinationController {
	
	private SecretCombination secretCombination;
	
	private SecretCombinationView secretCombinationView;
	
	SecretCombinationController() {
		this.secretCombination = new SecretCombination();
		this.secretCombinationView = new SecretCombinationView(this.secretCombination);
	}

	SecretCombination getSecretCombination() {
		return this.secretCombination;
	}

	SecretCombinationView getSecretCombinationView() {
		return this.secretCombinationView;
	}

}
