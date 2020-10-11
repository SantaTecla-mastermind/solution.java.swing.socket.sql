package usantatecla.mastermind;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.controllers.implementation.LogicImplementation;
import usantatecla.mastermind.models.DAO.SessionImplementationDAO;

public abstract class MastermindStandalone extends Mastermind{

	@Override
	protected Logic createLogic() {
		return new LogicImplementation(this.createDAO());
	}
	
	protected abstract SessionImplementationDAO createDAO();

}
