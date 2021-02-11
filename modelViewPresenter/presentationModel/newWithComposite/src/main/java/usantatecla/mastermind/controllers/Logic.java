package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.StateValue;

import java.util.HashMap;
import java.util.Map;

public class Logic {

    private Session session;
    private Map<StateValue, Controller> controllers;

    public Logic(Session session) {
        this.session = session;
        this.controllers = new HashMap<>();
        this.controllers.put(StateValue.INITIAL, new StartController(this.session));
        this.controllers.put(StateValue.IN_GAME, new PlayController(this.session));
        this.controllers.put(StateValue.FINAL, new ResumeController(this.session));
        this.controllers.put(StateValue.EXIT, null);
    }

    public Controller getController() {
        return this.controllers.get(this.session.getValueState());
    }

}
