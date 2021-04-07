package usantatecla.mastermind.controllers.proxy;

import usantatecla.mastermind.distributed.dispatchers.TCPIP;

abstract class ControllerProxy {

    protected TCPIP tcpip;

    protected ControllerProxy(TCPIP tcpip) {
        this.tcpip = tcpip;
    }

}
