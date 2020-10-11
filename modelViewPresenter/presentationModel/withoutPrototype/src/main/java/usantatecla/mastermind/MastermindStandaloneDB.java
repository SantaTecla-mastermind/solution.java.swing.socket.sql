package usantatecla.mastermind;

import usantatecla.mastermind.models.DAO.SessionImplementationDAO;
import usantatecla.mastermind.models.dataBase.SessionImplementationDBDAO;

public class MastermindStandaloneDB extends MastermindStandalone{
	
	protected SessionImplementationDAO createDAO() {
		return new SessionImplementationDBDAO();
	}
	
	public static void main(String[] args) {
		new MastermindStandaloneDB().play();
	}

}
