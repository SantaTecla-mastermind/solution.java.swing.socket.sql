package usantatecla.utils.models;

public abstract class Command {

	protected String title;
	
	protected Command(String title) {
		this.title = title;
	}

	protected abstract void execute();

	protected abstract boolean isActive();

	public String getTitle() {
		return this.title;
	}

}
