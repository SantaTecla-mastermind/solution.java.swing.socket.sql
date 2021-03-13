package usantatecla.mastermind.distributed.dispatchers;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.controllers.implementation.PlayControllerImplementation;
import usantatecla.mastermind.types.Color;

import java.util.ArrayList;
import java.util.List;

public class ErrorDispatcher extends Dispatcher {

    public ErrorDispatcher(PlayControllerImplementation playControllerImplementation) {
        super(playControllerImplementation);
    }

    @Override
    public void dispatch() {
        int size = this.tcpip.receiveInt();
        List<Color> colors = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            colors.add(this.tcpip.receiveColor());
        }
        this.tcpip.send(((PlayControllerImplementation) this.acceptorControllerImplementation).getError(colors));
    }
}
