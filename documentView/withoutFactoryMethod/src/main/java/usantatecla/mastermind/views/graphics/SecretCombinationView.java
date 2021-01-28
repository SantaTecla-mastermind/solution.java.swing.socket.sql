package usantatecla.mastermind.views.graphics;

import usantatecla.mastermind.views.Message;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
class SecretCombinationView extends JPanel {

    private static final String TITLE = "SECRET COMBINATION:";
    private final JLabel title;
    private final JLabel secretCombination;

    SecretCombinationView() {
        super();
        this.setLayout(new GridBagLayout());
        this.title = new JLabel(SecretCombinationView.TITLE);
        this.add(this.title, new Constraints(0, 0, 3, 1));
        String text = Message.SECRET_COMBINATION.toString();
        this.secretCombination = new JLabel(text);
        this.add(this.secretCombination, new Constraints(0, 1, 3, 1));
        this.setVisible(true);
    }
}
