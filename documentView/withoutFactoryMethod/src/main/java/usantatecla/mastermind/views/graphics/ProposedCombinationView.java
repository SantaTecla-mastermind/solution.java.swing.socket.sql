package usantatecla.mastermind.views.graphics;

import usantatecla.mastermind.models.Result;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;
import usantatecla.mastermind.views.ErrorView;

import java.util.List;

import javax.swing.*;

@SuppressWarnings("serial")
class ProposedCombinationView extends JLabel {

    private final List<Color> colors;

    private Error error;

    ProposedCombinationView(List<Color> colors) {
        this.colors = colors;
        String initials = "";
        for (Color color : this.colors) {
            initials += color.getInitial();
        }
        this.setText(initials);
    }

    void read(String characters) {
        this.error = Error.NULL;
        if (characters.length() != Result.WIDTH) {
            this.error = Error.WRONG_LENGTH;
        } else {
            for (int i = 0; i < characters.length(); i++) {
                Color color = Color.get(characters.charAt(i));
                if (color.isNull()) {
                    this.error = Error.WRONG_CHARACTERS;
                } else {
                    if (this.colors.contains(color)) {
                        this.error = Error.DUPLICATED;
                    } else {
                        this.colors.add(color);
                    }
                }
            }
        }
        if (!this.error.isNull()) {
            JOptionPane.showMessageDialog(null, ErrorView.MESSAGES[this.error.ordinal()], "ERROR",
                    JOptionPane.WARNING_MESSAGE);
            this.colors.clear();
        }
    }

    public boolean isOk() {
        return this.error.isNull();
    }

}
