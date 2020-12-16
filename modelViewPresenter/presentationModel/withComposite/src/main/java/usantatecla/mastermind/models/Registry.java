package usantatecla.mastermind.models;

import java.util.ArrayList;

class Registry {
	
	private ArrayList<Memento> mementoList;
	private Game game;
	private int firstPrevious;
	
	Registry(Game game) {
		this.game = game;
		this.mementoList = new ArrayList<>();
		this.mementoList.add(firstPrevious, this.game.createMemento());
		this.firstPrevious = 0;
	}

	void register() {
		for (int i = 0; i < this.firstPrevious; i++) {
			this.mementoList.remove(0);
		}
		this.firstPrevious = 0;
		this.mementoList.add(this.firstPrevious, this.game.createMemento());
	}

	void undo() {
		this.firstPrevious++;
		this.game.set(this.mementoList.get(this.firstPrevious));
	}

	void redo() {
		this.firstPrevious--;
		this.game.set(this.mementoList.get(this.firstPrevious));
	}

	boolean undoable() {
		return this.firstPrevious < this.mementoList.size() - 1;
	}

	boolean redoable() {
		return this.firstPrevious >= 1;
	}

	void reset() {
		this.mementoList = new ArrayList<>();
		this.mementoList.add(firstPrevious, this.game.createMemento());
		this.firstPrevious = 0;
	}

}
