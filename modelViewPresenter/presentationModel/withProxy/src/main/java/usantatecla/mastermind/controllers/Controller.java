package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.SessionImplementation;

public abstract class Controller {

    protected SessionImplementation sessionImplementation;

    protected Controller(SessionImplementation sessionImplementation) {
        this.sessionImplementation = sessionImplementation;
    }

}
