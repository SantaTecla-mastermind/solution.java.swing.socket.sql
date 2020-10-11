package usantatecla.mastermind.controllers;

import usantatecla.mastermind.events.NewGameEvent;
import usantatecla.mastermind.events.ProposeEvent;
import usantatecla.mastermind.events.RedoEvent;
import usantatecla.mastermind.events.UndoEvent;
import usantatecla.mastermind.models.Mastermind;
import usantatecla.mastermind.views.MastermindView;
import usantatecla.utils.Event;
import usantatecla.utils.Observed;
import usantatecla.utils.Observer;

class MastermindController implements Observer{
	
	private GameController gameController;
	
	private Mastermind mastermind;
	
	private MastermindView mastermindView;
	
	MastermindController() {
		this.clear();
	}
	
	void clear() {
		this.gameController = new GameController();
		this.mastermind = new Mastermind(this.gameController.getGame());
		this.mastermindView = new MastermindView(this.mastermind, this);	
		this.mastermindView.addObserver(this);
		this.mastermind.addObserver(this.mastermindView);	
	}
	
	void play() {
		this.mastermindView.write();
	}

	
	public void update(Observed observed, Event event) {
		if (event instanceof ProposeEvent) {
			this.gameController.proposeCombination();
			this.mastermind.proposeCombination();
		} else if (event instanceof UndoEvent) {
			this.mastermind.undo();
			this.gameController.reset();			
		} else if (event instanceof RedoEvent) {
			this.mastermind.redo();
			this.gameController.reset();
		} else if (event instanceof NewGameEvent) {
			this.clear();
			this.mastermind.clear();
			this.play();
		}
	}

	public static void main(String[] args) {
		new MastermindController().play();
	}

}
