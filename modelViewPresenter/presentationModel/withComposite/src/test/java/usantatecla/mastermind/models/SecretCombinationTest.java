package usantatecla.mastermind.models;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import usantatecla.mastermind.types.*;

public class SecretCombinationTest {
    private SecretCombination secretCombination;
    private ProposedCombination proposedCombination;

   public SecretCombinationTest () {
        this.secretCombination = new SecretCombination();
        List<Color> colors = new ArrayList<Color>();
        colors.add(Color.BLUE);
        colors.add(Color.GREEN);
        colors.add(Color.ORANGE);
        colors.add(Color.PURPLE);
        this.secretCombination.colors = colors;

}

@Test
public void testGetResultObtainBlackAndWhitesThenGet2BlacksAnd2Whites(){
    List<Color> colors2 = new ArrayList<Color>();
        colors2.add(Color.GREEN);
        colors2.add(Color.BLUE);
        colors2.add(Color.ORANGE);
        colors2.add(Color.PURPLE);
        Result result = this.secretCombination.getResult(new ProposedCombination(colors2));
        assertEquals(2, result.getBlacks());
        assertEquals(2, result.getWhites());
}

@Test
public void testGetResultObtainBlackAndWhitesThenGet4BlacksAnd0Whites(){
    List<Color> colors2 = new ArrayList<Color>();
        colors2.add(Color.BLUE);
        colors2.add(Color.GREEN);
        colors2.add(Color.ORANGE);
        colors2.add(Color.PURPLE);
        Result result = this.secretCombination.getResult(new ProposedCombination(colors2));
        assertEquals(4, result.getBlacks());
        assertEquals(0, result.getWhites());
}

}