package usantatecla.mastermind.distributed;

import usantatecla.mastermind.controllers.implementation.LogicImplementation;
import usantatecla.mastermind.distributed.dispatchers.ColorsDispatcher;
import usantatecla.mastermind.distributed.dispatchers.BlacksDispatcher;
import usantatecla.mastermind.distributed.dispatchers.DispatcherPrototype;
import usantatecla.mastermind.distributed.dispatchers.FrameType;
import usantatecla.mastermind.distributed.dispatchers.LooserDispatcher;
import usantatecla.mastermind.distributed.dispatchers.ProposeCombinationDispatcher;
import usantatecla.mastermind.distributed.dispatchers.RedoDispatcher;
import usantatecla.mastermind.distributed.dispatchers.RedoableDispatcher;
import usantatecla.mastermind.distributed.dispatchers.ResumeDispatcher;
import usantatecla.mastermind.distributed.dispatchers.StartDispatcher;
import usantatecla.mastermind.distributed.dispatchers.StateDispatcher;
import usantatecla.mastermind.distributed.dispatchers.AttemptsDispatcher;
import usantatecla.mastermind.distributed.dispatchers.UndoDispatcher;
import usantatecla.mastermind.distributed.dispatchers.UndoableDispatcher;
import usantatecla.mastermind.distributed.dispatchers.WhitesDispatcher;
import usantatecla.mastermind.distributed.dispatchers.WidthDispatcher;
import usantatecla.mastermind.distributed.dispatchers.WinnerDispatcher;

public class LogicImplementationServer extends LogicImplementation {

	public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
		dispatcherPrototype.add(FrameType.START, new StartDispatcher(this.startControllerImplementation));
		dispatcherPrototype.add(FrameType.STATE, new StateDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.UNDO, new UndoDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.REDO, new RedoDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.UNDOABLE, new UndoableDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.REDOABLE, new RedoableDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.WINNER, new WinnerDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.LOOSER, new LooserDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.ATTEMPTS, new AttemptsDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.COLORS, new ColorsDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.PROPOSECOMBINATION,
				new ProposeCombinationDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.WIDTH, new WidthDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.BLACKS, new BlacksDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.WHITES, new WhitesDispatcher(this.playControllerImplementation));
		dispatcherPrototype.add(FrameType.NEW_GAME, new ResumeDispatcher(this.resumeControllerImplementation));
	}

}
