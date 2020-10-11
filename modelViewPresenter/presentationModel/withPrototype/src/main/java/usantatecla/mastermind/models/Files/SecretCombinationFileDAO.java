package usantatecla.mastermind.models.Files;

import java.io.BufferedReader;
import usantatecla.mastermind.models.SecretCombination;

public class SecretCombinationFileDAO extends CombinationFileDAO {

	SecretCombinationFileDAO(SecretCombination secretCombination) {
		super(secretCombination);
	}

	public void load(BufferedReader bufferedReader) {
		this.combination.clearColors();
		super.load(bufferedReader);
	}

}
