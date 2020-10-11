package usantatecla.mastermind.distributed;

import usantatecla.mastermind.Mastermind;

public class MastermindClient extends Mastermind{
	
	public MastermindClient() {
		this.logic = new LogicProxy();
	}
	
	@Override
	protected void play() {
		super.play();
		((LogicProxy) this.logic).close();
	}
	
	public static void main(String[] args) {
		new MastermindClient().play();
	}

}
