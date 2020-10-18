package usantatecla.mastermind;

import java.util.Random;

import usantatecla.utils.Console;

import java.util.Collections;

class SecretCombination extends Combination {

	SecretCombination() {
		super();
		for(int i=0; i<Color.length(); i++) {
			this.colors.add(Color.get(i));
		}
		Random random = new Random(System.currentTimeMillis());
		for (int i = 0; i < Color.length() - Result.WIDTH; i++) {
			this.colors.remove(random.nextInt(this.colors.size()));
		}
		Collections.shuffle(this.colors);
	}

	Result getResult(ProposedCombination proposedCombination) {
		int blacks = 0;
		int whites = 0;
		for (int i = 0; i < this.colors.size(); i++) {
			if (proposedCombination.contains(this.colors.get(i), i)) {
				blacks++;
			}
			if (proposedCombination.contains(this.colors.get(i))) {
				whites++;
			}
		}
		return new Result(blacks, whites - blacks);
	}

	void writeln() {
		Message.SECRET_COMBINATION.write();
		Console.getInstance().writeln();
	}

}
