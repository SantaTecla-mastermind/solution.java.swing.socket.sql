package usantatecla.mastermind.models;

import java.io.BufferedReader;
import java.util.Collections;
import java.util.Random;

import usantatecla.mastermind.types.Color;

class SecretCombination extends Combination {

	SecretCombination() {
		for(Color color: Color.values()) {
			this.colors.add(color);
		}
		Random random = new Random(System.currentTimeMillis());
		for (int i = 0; i < Color.length() - Combination.getWidth(); i++) {
			this.colors.remove(random.nextInt(this.colors.size()));
		}
		Collections.shuffle(this.colors);
	}
	
	public void load(BufferedReader bufferedReader) {
		this.colors.clear();
		super.load(bufferedReader);
	}

	Result getResult(ProposedCombination proposedCombination) {
		int blacks = 0;
		System.out.println(this.colors.size());
		for (int i = 0; i < this.colors.size(); i++) {
			if (proposedCombination.contains(this.colors.get(i), i)) {
				blacks++;
			}
		}
		int whites = 0;
		for (Color color : this.colors) {
			if (proposedCombination.contains(color)) {
				whites++;
			}
		}
		return new Result(blacks, whites - blacks);
	}

}
