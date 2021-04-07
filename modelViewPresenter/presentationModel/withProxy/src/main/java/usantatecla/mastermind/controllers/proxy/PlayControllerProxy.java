package usantatecla.mastermind.controllers.proxy;

import usantatecla.mastermind.controllers.ControllersVisitor;
import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.distributed.dispatchers.FrameType;
import usantatecla.mastermind.distributed.dispatchers.TCPIP;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.List;

public class PlayControllerProxy extends AcceptorControllerProxy implements PlayController {

    public PlayControllerProxy(TCPIP tcpip) {
        super(tcpip);
    }

    public boolean undoable() {
        this.tcpip.send(FrameType.UNDOABLE.name());
        return this.tcpip.receiveBoolean();
    }

    public boolean redoable() {
        this.tcpip.send(FrameType.REDOABLE.name());
        return this.tcpip.receiveBoolean();
    }

    public void undo() {
        this.tcpip.send(FrameType.UNDO.name());
    }

    public void redo() {
        this.tcpip.send(FrameType.REDO.name());
    }

    public Error getError(List<Color> colors) {
        this.tcpip.send(FrameType.ERROR.name());
        this.tcpip.send(colors.size());
        for (Color color : colors) {
            this.tcpip.send(color);
        }
        return this.tcpip.receiveError();
    }

    public void add(List<Color> colors) {
        this.tcpip.send(FrameType.ADD_PROPOSED_COMBINATION.name());
        this.tcpip.send(colors.size());
        for (Color color : colors) {
            this.tcpip.send(color);
        }
    }

    public boolean isFinished() {
        this.tcpip.send(FrameType.FINISHED.name());
        return this.tcpip.receiveBoolean();
    }

    public boolean isWinner() {
        this.tcpip.send(FrameType.WINNER.name());
        return this.tcpip.receiveBoolean();
    }

    public void accept(ControllersVisitor controllersVisitor) {
        controllersVisitor.visit(this);
    }

}
