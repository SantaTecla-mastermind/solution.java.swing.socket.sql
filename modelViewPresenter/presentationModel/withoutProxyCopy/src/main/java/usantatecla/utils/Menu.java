package usantatecla.utils;

import java.util.ArrayList;

public abstract class Menu {

	private static final String OPTION = "----- Choose one option -----";
	private ArrayList<Command> commandList;

	public Menu() {
		this.commandList = new ArrayList<>();
	}

	public void execute() {
		ArrayList<Command> commands = new ArrayList<>();
		for (int i = 0; i < this.commandList.size(); i++) {
			if (this.commandList.get(i).isActive()) {
				commands.add(this.commandList.get(i));
			}
		}
		boolean error;
		int option;
		do {
			error = false;
			Console.getInstance().writeln();
			Console.getInstance().writeln(Menu.OPTION);
			for (int i = 0; i < commands.size(); i++) {
				Console.getInstance().writeln((i + 1) + ") " + commands.get(i).getTitle());
			}
			option = Console.getInstance().readInt("") - 1;
			if (!new ClosedInterval(0, commands.size()-1).includes(option)) {
				error = true;
			} 				
		} while (error);
		commands.get(option).execute();
	}

	protected void addCommand(Command command) {
		this.commandList.add(command);
	}

}
