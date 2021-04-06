package usantatecla.mastermind.controllers;

import usantatecla.mastermind.distributed.dispatchers.TCPIP;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.StateValue;

import java.util.HashMap;
import java.util.Map;

public class Logic {

    private Session session;
    private Map<StateValue, AcceptorController> acceptorControllers;
    protected StartController startController;
    protected PlayController playController;
    protected ResumeController resumeController;
    private TCPIP tcpip;

    public Logic(boolean isStandalone) {
        if (isStandalone) {
            this.tcpip = null;
        } else {
            this.tcpip = TCPIP.createClientSocket();
        }
        this.session = new Session(this.tcpip);
        this.acceptorControllers = new HashMap<>();
        this.startController = new StartController(this.session, this.tcpip);
        this.acceptorControllers.put(StateValue.INITIAL, this.startController);
        this.playController = new PlayController(this.session, this.tcpip);
        this.acceptorControllers.put(StateValue.IN_GAME, this.playController);
        this.resumeController = new ResumeController(this.session, this.tcpip);
        this.acceptorControllers.put(StateValue.RESUME, this.resumeController);
        this.acceptorControllers.put(StateValue.EXIT, null);
    }

    public AcceptorController getController() {
        return this.acceptorControllers.get(this.session.getValueState());
    }

    public void close() {
        this.tcpip.close();
    }

}
