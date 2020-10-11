package usantatecla.mastermind.views;

import usantatecla.mastermind.controllers.AcceptorController;
import usantatecla.mastermind.controllers.ControllersVisitor;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.controllers.ResumeController;
import usantatecla.mastermind.controllers.SaveController;
import usantatecla.mastermind.controllers.StartController;

public class View implements ControllersVisitor {
	
	private StartView startView;
	
	private PlayView playView;
	
	private SaveView saveView;
	
	private ResumeView resumeView;
	
	public View(){
		this.startView = new StartView();
		this.playView = new PlayView();
		this.saveView = new SaveView();
		this.resumeView = new ResumeView();
	}
	
	public void interact(AcceptorController acceptorController) {
		acceptorController.accept(this);
	}

	
	public void visit(StartController startController) {
		this.startView.interact(startController);	
		System.out.println();
	}

	
	public void visit(PlayController playController) {
		this.playView.interact(playController);
	}
	
	
	public void visit(SaveController saveController) {
		this.saveView.interact(saveController);
	}

	
	public void visit(ResumeController resumeController) {
		this.resumeView.interact(resumeController);
	}

}
