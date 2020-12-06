package usantatecla.mastermind.views.graphics;

import usantatecla.mastermind.models.Combination;
import usantatecla.mastermind.models.ProposedCombination;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.mastermind.views.ColorView;

import javax.swing.*;

@SuppressWarnings("serial")
class ProposedCombinationView extends JLabel {

    private ProposedCombination proposedCombination;

    private Error error;

    ProposedCombinationView(ProposedCombination proposedCombination) {
        this.proposedCombination = proposedCombination;
        String initials = "";
        for (Color color : proposedCombination.getColors()) {
            initials += ColorView.INITIALS[color.ordinal()];
        }
        this.setText(initials);
    }

	void read(String characters) {
        this.error = Error.NULL;
        if (characters.length() != Combination.getWidth()) {
            this.error = Error.WRONG_LENGTH;
        } else {
            for (int i = 0; i < characters.length(); i++) {
                Color color = ColorView.getInstance(characters.charAt(i));
                if (color.isNull()) {
                    this.error = Error.WRONG_CHARACTERS;
                } else {
                    if (this.proposedCombination.getColors().contains(color)) {
                        this.error = Error.DUPLICATED;
                    } else {
                        this.proposedCombination.getColors().add(color);
                    }
                }
            }
        }
        if (!this.error.isNull()) {
            JOptionPane.showMessageDialog(null, new ErrorView().MESSAGES[this.error.ordinal()], "ERROR",
                    JOptionPane.WARNING_MESSAGE);
            this.proposedCombination.getColors().clear();
        }
    }

    public boolean isOk() {
        return this.error.isNull();
    }

}
