package usantatecla.mastermind;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.controllers.implementation.LogicImplementation;
import usantatecla.mastermind.models.DAO.SessionImplementationDAO;

public class MastermindStandalone extends Mastermind{

	@Override
	protected Logic createLogic() {
		return new LogicImplementation(new SessionImplementationDAO());
	}
	
	public static void main(String[] args) {
		new MastermindStandalone().play();
	}

}
