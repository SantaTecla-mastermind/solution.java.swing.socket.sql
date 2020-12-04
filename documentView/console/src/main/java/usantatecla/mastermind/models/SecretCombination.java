package usantatecla.mastermind.models;

import usantatecla.mastermind.types.Color;

import java.util.Collections;
import java.util.Random;

public class SecretCombination extends Combination {

    SecretCombination() {
        for (Color color : Color.values()) {
            if (!color.isNull()) this.colors.add(color);
        }
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < (Color.length() - 1) - Combination.getWidth(); i++) {
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
            } else if (proposedCombination.contains(this.colors.get(i))) {
                whites++;
            }
        }
        return new Result(blacks, whites);
    }

}
