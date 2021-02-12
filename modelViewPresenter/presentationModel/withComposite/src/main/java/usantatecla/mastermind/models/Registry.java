package usantatecla.mastermind.models;

import java.util.ArrayList;
import java.util.List;

class Registry {
	
	private List<Memento> mementoList;
	private Board board;
	private int firstPrevious;
	
	Registry(Board board) {
		this.board = board;
		this.reset();
	}

	void reset() {
		this.firstPrevious = 0;
		this.mementoList = new ArrayList<>();
		this.mementoList.add(this.firstPrevious, this.board.createMemento());
	}

	void register() {
		for (int i = 0; i < this.firstPrevious; i++) {
			this.mementoList.remove(0);
		}
		this.firstPrevious = 0;
		this.mementoList.add(this.firstPrevious, this.board.createMemento());
	}

	void undo() {
		assert this.undoable();
		this.firstPrevious++;
		this.board.setMemento(this.mementoList.get(this.firstPrevious));
	}

	void redo() {
		assert this.redoable();
		this.firstPrevious--;
		this.board.setMemento(this.mementoList.get(this.firstPrevious));
	}

	boolean undoable() {
		return this.firstPrevious < this.mementoList.size() - 1;
	}

	boolean redoable() {
		return this.firstPrevious >= 1;
	}

}
