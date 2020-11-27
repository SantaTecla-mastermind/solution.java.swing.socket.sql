package usantatecla.mastermind.views.console;

import usantatecla.mastermind.controllers.ProposalController;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.views.Message;
import usantatecla.utils.Console;

import java.util.ArrayList;
import java.util.List;

class ProposedCombinationView {

    private ProposalController proposalController;

    ProposedCombinationView(ProposalController proposalController) {
        this.proposalController = proposalController;
    }

    void write(int position) {
        for (Color color : this.proposalController.getProposedCombination(position).getColors()) {
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
