package usantatecla.mastermind.controllers;

import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.List;

public interface PlayController extends AcceptorController {

    boolean undoable();
    boolean redoable();
    void undo();
    void redo();
    Error getError(List<Color> colors);
    void add(List<Color> colors);
    boolean isFinished();
    boolean isWinner();

}
