package usantatecla.mastermind.models;

import usantatecla.mastermind.distributed.dispatchers.FrameType;
import usantatecla.mastermind.distributed.dispatchers.TCPIP;

public class SessionProxy implements Session {

    private TCPIP tcpip;

    public SessionProxy(TCPIP tcpip) {
        this.tcpip = tcpip;
    }

    public StateValue getValueState() {
        this.tcpip.send(FrameType.STATE_VALUE.name());
        return StateValue.valueOf(this.tcpip.receiveLine());
    }
}
