package usantatecla.mastermind.distributed;

import usantatecla.mastermind.controllers.Logic;
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

public class LogicServer extends Logic {

	public LogicServer(Boolean isStandalone) {
		super(isStandalone);
	}

	public void createDispatchers(DispatcherPrototype dispatcherPrototype) {
		dispatcherPrototype.add(FrameType.START, new StartDispatcher(this.startController));
		dispatcherPrototype.add(FrameType.STATE, new StateDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.UNDO, new UndoDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.REDO, new RedoDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.UNDOABLE, new UndoableDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.REDOABLE, new RedoableDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.WINNER, new WinnerDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.LOOSER, new LooserDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.ATTEMPTS, new AttemptsDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.COLORS, new ColorsDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.PROPOSECOMBINATION,
				new ProposeCombinationDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.WIDTH, new WidthDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.BLACKS, new BlacksDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.WHITES, new WhitesDispatcher(this.playController));
		dispatcherPrototype.add(FrameType.NEW_GAME, new ResumeDispatcher(this.resumeController));
	}

}
