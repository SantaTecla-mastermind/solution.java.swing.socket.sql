package usantatecla.mastermind.controllers;

import usantatecla.mastermind.distributed.dispatchers.FrameType;
import usantatecla.mastermind.distributed.dispatchers.TCPIP;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.List;

public class PlayController extends AcceptorController {

    private ProposalController proposalController;
    private UndoController undoController;
    private RedoController redoController;

    public PlayController(Session session, TCPIP tcpip) {
        super(session, tcpip);
        this.proposalController = new ProposalController(this.session);
        this.undoController = new UndoController(this.session);
        this.redoController = new RedoController(this.session);
    }

    public boolean undoable() {
        if (this.tcpip == null) {
            return this.undoController.undoable();
        } else {
            this.tcpip.send(FrameType.UNDOABLE.name());
            return this.tcpip.receiveBoolean();
        }
    }

    public boolean redoable() {
        if (this.tcpip == null) {
            return this.redoController.redoable();
        } else {
            this.tcpip.send(FrameType.REDOABLE.name());
            return this.tcpip.receiveBoolean();
        }
    }

    public void undo() {
        if (this.tcpip == null) {
            this.undoController.undo();
        } else {
            this.tcpip.send(FrameType.UNDO.name());
        }
    }

    public void redo() {
        if (this.tcpip == null) {
            this.redoController.redo();
        } else {
            this.tcpip.send(FrameType.REDO.name());
        }
    }

    public Error getError(List<Color> colors) {
        if (this.tcpip == null) {
            return this.proposalController.getError(colors);
        } else {
            this.tcpip.send(FrameType.ERROR.name());
            this.tcpip.send(colors.size());
            for (Color color : colors) {
                this.tcpip.send(color);
            }
            return this.tcpip.receiveError();
        }
    }

    public void add(List<Color> colors) {
        if (this.tcpip == null) {
            this.proposalController.add(colors);
        } else {
            this.tcpip.send(FrameType.ADD_PROPOSED_COMBINATION.name());
            this.tcpip.send(colors.size());
            for (Color color : colors) {
                this.tcpip.send(color);
            }
        }
    }

    public boolean isFinished() {
        if (this.tcpip == null) {
            return this.proposalController.isFinished();
        } else {
            this.tcpip.send(FrameType.FINISHED.name());
            return this.tcpip.receiveBoolean();
        }
    }

    public boolean isWinner() {
        if (this.tcpip == null) {
            return this.proposalController.isWinner();
        } else {
            this.tcpip.send(FrameType.WINNER.name());
            return this.tcpip.receiveBoolean();
        }
    }

    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
