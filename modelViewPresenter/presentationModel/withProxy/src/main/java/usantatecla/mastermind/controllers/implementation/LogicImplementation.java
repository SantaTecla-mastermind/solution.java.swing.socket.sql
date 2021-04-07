package usantatecla.mastermind.controllers.implementation;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.models.SessionImplementation;
import usantatecla.mastermind.models.StateValue;

public class LogicImplementation extends Logic {

    protected StartControllerImplementation startControllerImplementation;
    protected PlayControllerImplementation playControllerImplementation;
    protected ResumeControllerImplementation resumeControllerImplementation;

    public LogicImplementation() {
        this.session = new SessionImplementation();
        this.startControllerImplementation = new StartControllerImplementation((SessionImplementation) this.session);
        this.playControllerImplementation = new PlayControllerImplementation((SessionImplementation) this.session);
        this.resumeControllerImplementation = new ResumeControllerImplementation((SessionImplementation) this.session);
        this.acceptorControllers.put(StateValue.INITIAL, this.startControllerImplementation);
        this.acceptorControllers.put(StateValue.IN_GAME, this.playControllerImplementation);
        this.acceptorControllers.put(StateValue.RESUME, this.resumeControllerImplementation);
        this.acceptorControllers.put(StateValue.EXIT, null);
    }

}
