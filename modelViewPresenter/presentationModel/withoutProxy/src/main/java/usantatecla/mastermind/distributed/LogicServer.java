package usantatecla.mastermind.distributed;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.distributed.dispatchers.*;

public class LogicServer extends Logic {

	public LogicServer(Boolean isStandalone) {
		super(isStandalone);
	}

	public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
		dispatcherPrototype.add(FrameType.STATE_VALUE, new StateValueDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.NEXT_STATE, new NextStateDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.ATTEMPTS, new AttemptsDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.COLORS, new ColorsDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.BLACKS, new BlacksDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.WHITES, new WhitesDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.ERROR, new ErrorDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.ADD_PROPOSED_COMBINATION,
				new AddProposedCombinationDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.UNDOABLE, new UndoableDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.REDOABLE, new RedoableDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.UNDO, new UndoDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.REDO, new RedoDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.FINISHED, new FinishedDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.WINNER, new WinnerDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.RESET, new ResetDispatcher(this.resumeController));
	}

}
