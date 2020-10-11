package usantatecla.mastermind.views;

import java.util.ArrayList;

import usantatecla.mastermind.models.Mastermind;
import usantatecla.utils.Command;
import usantatecla.utils.Observer;

class Menu extends usantatecla.utils.Menu {

	Menu(Mastermind mastermind, Observer observer) {
		this.commands = new ArrayList<Command>();
		this.commands.add(new ProposeCommand(mastermind, observer));
		this.commands.add(new UndoCommand(mastermind, observer));
		this.commands.add(new RedoCommand(mastermind, observer));
	}

}
