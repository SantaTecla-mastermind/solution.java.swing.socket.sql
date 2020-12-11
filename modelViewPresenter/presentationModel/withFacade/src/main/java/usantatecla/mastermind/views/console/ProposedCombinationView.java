package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.Logic;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.views.Message;
import usantatecla.mastermind.views.WithLogicView;
import usantatecla.utils.Console;

import java.util.ArrayList;
import java.util.List;

class ProposedCombinationView extends WithLogicView {

    ProposedCombinationView(Logic logic) {
        super(logic);
    }

    void write(int i) {
        for (Color color : this.logic.getProposedCombination(i)) {
            new ColorView(color).write();
        }
    }

    List<Color> read() {
        String characters = Console.getInstance().readString(Message.PROPOSED_COMBINATION.getMessage());
        List<Color> colors = new ArrayList<>();
        for (int i = 0; i < characters.length(); i++) {
            colors.add(ColorView.getInstance(characters.charAt(i)));
        }
        return colors;
    }

}
