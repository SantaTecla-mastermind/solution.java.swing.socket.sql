package usantatecla.mastermind.models;

import usantatecla.mastermind.distributed.dispatchers.FrameType;
import usantatecla.mastermind.distributed.dispatchers.TCPIP;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.List;

public class Session {

	private State state;
	private Board board;
	private Registry registry;
	private TCPIP tcpip;
	
	public Session(TCPIP tcpip) {
		this.state = new State();
		this.board = new Board();
		this.registry = new Registry(this.board);
		this.tcpip = tcpip;
	}

	public void reset() {
		this.board.reset();
		this.state.reset();
		this.registry.reset();
	}

	public void nextState() {
		this.state.next();		
	}

	public StateValue getValueState() {
		if (this.tcpip == null) {
			return this.state.getValueState();
		} else {
			this.tcpip.send(FrameType.STATE_VALUE.name());
			return StateValue.valueOf(this.tcpip.receiveLine());
		}
	}

	public boolean undoable() {
		return this.registry.undoable();
	}

	public boolean redoable() {
		return this.registry.redoable();
	}

	public void undo() {
		this.registry.undo();
	}

	public void redo() {
		this.registry.redo();
	}

	public void add(List<Color> colors) {
		this.board.add(colors);
		this.registry.register();
	}

	public int getBlacks(int position) {
		return this.board.getBlacks(position);
	}

	public int getWhites(int position) {
		return this.board.getWhites(position);
	}

	public List<Color> getProposedCombinationColors(int position) {
		return this.board.getProposedCombinationColors(position);
	}

	public Error getError(List<Color> colors) {
		return this.board.getError(colors);
	}

	public int getAttempts() {
		return this.board.getAttempts();
	}

	public boolean isFinished() {
		return this.board.isFinished();
	}

	public boolean isWinner() {
		return this.board.isWinner();
	}

}
