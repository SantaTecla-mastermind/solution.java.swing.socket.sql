package usantatecla.mastermind;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.controllers.implementation.LogicImplementation;

public class MastermindStandalone extends Mastermind{

	@Override
	protected Logic createLogic() {
		return new LogicImplementation();
	}
	
	public static void main(String[] args) {
		new MastermindStandalone().play();
	}

}
