package usantatecla.mastermind.controllers.proxy;

import usantatecla.mastermind.controllers.ControllersVisitor;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.distributed.dispatchers.TCPIP;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.List;

public class PlayControllerProxy extends AcceptorControllerProxy implements PlayController {

    // TODO Proposal, Undo y Redo se traen directamente aquí
    private ProposalControllerProxy proposalControllerProxy;
    private UndoControllerProxy undoControllerProxy;
    private RedoControllerProxy redoControllerProxy;

    public PlayControllerProxy(Session session, TCPIP tcpip) {
        super(session, tcpip);
        this.proposalControllerProxy = new ProposalControllerProxy(this.session, this.tcpip);
        this.undoControllerProxy = new UndoControllerProxy(this.session, this.tcpip);
        this.redoControllerProxy = new RedoControllerProxy(this.session, this.tcpip);
    }

    public boolean undoable() {
        return this.undoControllerProxy.undoable();
    }

    public boolean redoable() {
        return this.redoControllerProxy.redoable();
    }

    public void undo() {
        this.undoControllerProxy.undo();
    }

    public void redo() {
        this.redoControllerProxy.redo();
    }

    public Error getError(List<Color> colors) {
        return this.proposalControllerProxy.getError(colors);
    }

    public void add(List<Color> colors) {
        this.proposalControllerProxy.add(colors);
    }

    public boolean isFinished() {
        return this.proposalControllerProxy.isFinished();
    }

    public boolean isWinner() {
        return this.proposalControllerProxy.isWinner();
    }

    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
