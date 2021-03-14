package usantatecla.mastermind.controllers.proxy;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.distributed.dispatchers.FrameType;
import usantatecla.mastermind.distributed.dispatchers.TCPIP;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.List;

public class ProposalControllerProxy extends ControllerProxy implements ProposalController {

    public ProposalControllerProxy(Session session, TCPIP tcpip) {
        super(session, tcpip);
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

}
