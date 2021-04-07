package usantatecla.mastermind.controllers.proxy;

import usantatecla.mastermind.controllers.AcceptorController;
import usantatecla.mastermind.distributed.dispatchers.FrameType;
import usantatecla.mastermind.distributed.dispatchers.TCPIP;
import usantatecla.mastermind.types.Color;

import java.util.ArrayList;
import java.util.List;

public abstract class AcceptorControllerProxy extends ControllerProxy implements AcceptorController {

    AcceptorControllerProxy(TCPIP tcpip) {
        super(tcpip);
    }

    public void nextState() {
        this.tcpip.send(FrameType.NEXT_STATE.name());
    }

    public int getAttempts() {
        this.tcpip.send(FrameType.ATTEMPTS.name());
        return this.tcpip.receiveInt();
    }

    public List<Color> getProposedCombinationColors(int position) {
        this.tcpip.send(FrameType.COLORS.name());
        this.tcpip.send(position);
        int size = this.tcpip.receiveInt();
        List<Color> colors = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            colors.add(this.tcpip.receiveColor());
        }
        return colors;
    }

    public int getBlacks(int position) {
        this.tcpip.send(FrameType.BLACKS.name());
        this.tcpip.send(position);
        return this.tcpip.receiveInt();
    }

    public int getWhites(int position) {
        this.tcpip.send(FrameType.WHITES.name());
        this.tcpip.send(position);
        return this.tcpip.receiveInt();
    }

}
