package usantatecla.mastermind.distributed.dispatchers;

public enum FrameType {

	NEXT_STATE,
	UNDO, 
	REDO, 
	UNDOABLE, 
	REDOABLE,
	ADD_PROPOSED_COMBINATION,
	ERROR,
	FINISHED,
	WINNER,
	ATTEMPTS, 
	COLORS,
	STATE_VALUE,
	BLACKS,
	WHITES,
	RESET,
	CLOSE;

	public static FrameType parser(String string) {
		for(FrameType frameType : FrameType.values()) {
			if (frameType.name().equals(string)) {
				return frameType;
			}
		}
		return null;
	}
}
