package usantatecla.mastermind.views;

import usantatecla.mastermind.models.Session;

public abstract class Command extends usantatecla.utils.Command {
	
	protected Session session;
	
	protected Command(String title, Session session) {
		super(title);
		this.session = session;
	}

	@Override
	public abstract void updateIsActive();

}
