package usantatecla.mastermind.distributed;

import usantatecla.mastermind.controllers.implementation.LogicImplementation;
import usantatecla.mastermind.distributed.dispatchers.*;
public class LogicImplementationServer extends LogicImplementation {

	public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
		dispatcherPrototype.add(FrameType.STATE_VALUE, new StateValueDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.NEXT_STATE, new NextStateDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.ATTEMPTS, new AttemptsDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.COLORS, new ColorsDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.BLACKS, new BlacksDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.WHITES, new WhitesDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.ERROR, new ErrorDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.ADD_PROPOSED_COMBINATION,
				new AddProposedCombinationDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.UNDOABLE, new UndoableDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.REDOABLE, new RedoableDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.UNDO, new UndoDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.REDO, new RedoDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.FINISHED, new FinishedDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.WINNER, new WinnerDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.RESET, new ResetDispatcher(this.resumeControllerImplementation));
	}

}
