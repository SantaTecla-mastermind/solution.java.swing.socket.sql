package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.models.State;
import usantatecla.mastermind.models.StateValue;

import java.util.HashMap;
import java.util.Map;

public class Logic {

    private Board board;
    private State state;
    private Map<StateValue, Controller> controllers;

    public Logic() {
        this.state = new State();
        this.board = new Board();
        this.controllers = new HashMap<>();
        this.controllers.put(StateValue.INITIAL, new StartController(this.board, this.state));
        this.controllers.put(StateValue.IN_GAME, new PlayController(this.board, this.state));
        this.controllers.put(StateValue.FINAL, new ResumeController(this.board, this.state));
        this.controllers.put(StateValue.EXIT, null);
    }

    public Controller getController() {
        return this.controllers.get(this.state.getValueState());
    }

}
