package usantatecla.mastermind.views.graphics;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;

import usantatecla.mastermind.views.MessageView;

@SuppressWarnings("serial")
class ProposalCombinationView extends JPanel implements ActionListener, KeyListener{
	
	private static final String ACCEPT = "Ok";
	
	private final JLabel label;

	private final JTextField textField;

	private final JButton button;

	private String characters;

	ProposalCombinationView(final JRootPane rootPane) {
		this.setLayout(new GridBagLayout());
		this.label = new JLabel(MessageView.PROPOSED_COMBINATION.getMessage());
		this.button = new JButton(ProposalCombinationView.ACCEPT);
		this.textField = new JTextField(10);
		this.resetCharacters();
		this.add(label, new Constraints(0, 0, 1, 1));
		this.add(textField, new Constraints(0, 1, 1, 1));
		this.add(button, new Constraints(0, 2, 1, 1));
		rootPane.setDefaultButton(this.button);
		this.button.addActionListener(this);
		this.button.addKeyListener(this);
	}

	void resetCharacters() {
		this.characters = null;
	}

	String getCharacters() {
		return this.characters;
	}

	
	public void actionPerformed(final ActionEvent event) {
		this.characters = this.textField.getText();
		this.textField.setText("");
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
