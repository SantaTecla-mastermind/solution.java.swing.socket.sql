package usantatecla.mastermind.controllers.implementation;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.StateValue;

public class LogicImplementation extends Logic {

    protected StartControllerImplementation startControllerImplementation;
    protected PlayControllerImplementation playController;
    protected ResumeControllerImplementation resumeController;

    public LogicImplementation(Session session) {
        super(session);
        this.startControllerImplementation = new StartControllerImplementation(this.session);
        this.acceptorControllers.put(StateValue.INITIAL, this.startControllerImplementation);
        this.playController = new PlayControllerImplementation(this.session);
        this.acceptorControllers.put(StateValue.IN_GAME, this.playController);
        this.resumeController = new ResumeControllerImplementation(this.session);
        this.acceptorControllers.put(StateValue.RESUME, this.resumeController);
        this.acceptorControllers.put(StateValue.EXIT, null);
    }

}
