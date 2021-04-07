package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.StateValue;

import java.util.HashMap;
import java.util.Map;

public class Logic {

    protected Session session;
    protected Map<StateValue, AcceptorController> acceptorControllers;

    protected Logic() {
        this.acceptorControllers = new HashMap<>();
    }

    public AcceptorController getController() {
        return this.acceptorControllers.get(this.session.getValueState());
    }

}
