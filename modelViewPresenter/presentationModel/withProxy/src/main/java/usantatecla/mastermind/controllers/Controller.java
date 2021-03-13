package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Session;

public abstract class Controller {

    protected Session session;

    protected Controller(Session session) {
        this.session = session;
    }

}
