package usantatecla.mastermind;

import java.util.Collections;
import java.util.Random;

class SecretCombination extends Combination {

    SecretCombination() {
        super();
        this.colorCodes = ColorFactory.getInstance().getColors();
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < ColorFactory.getInstance().length() - Result.WIDTH; i++) {
            this.colorCodes.remove(random.nextInt(this.colorCodes.size()));
        }
        Collections.shuffle(this.colorCodes);
    }

    Result getResult(ProposedCombination proposedCombination) {
        int blacks = 0;
        int whites = 0;
        for (int i = 0; i < this.colorCodes.size(); i++) {
            if (proposedCombination.contains(this.colorCodes.get(i), i)) {
                blacks++;
            }
            if (proposedCombination.contains(this.colorCodes.get(i))) {
                whites++;
            }
        }
        return new Result(blacks, whites - blacks);
    }

    void writeln() {
        Message.SECRET_COMBINATION.writeln();
    }

}
