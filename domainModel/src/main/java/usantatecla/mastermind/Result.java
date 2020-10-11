package usantatecla.mastermind;

class Result {

	public static final int WIDTH = 4;
	private int blacks = 0;
	private int whites = 0;

	Result(int blacks, int whites) {
		assert blacks >= 0;
		assert whites >= 0;

		this.blacks = blacks;
		this.whites = whites;
	}

	boolean isWinner() {
		return this.blacks == Result.WIDTH;
	}

	void writeln() {
		Message.RESULT.writeln(this.blacks, this.whites);
	}
	
}
