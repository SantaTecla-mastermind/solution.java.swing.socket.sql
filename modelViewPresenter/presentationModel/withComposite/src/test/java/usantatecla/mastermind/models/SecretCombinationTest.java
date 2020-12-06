package usantatecla.mastermind.models;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import org.junit.jupiter.api.Test;
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
    List<Color> colors2 = new ArrayList<>();
        colors2.add(Color.GREEN);
        colors2.add(Color.BLUE);
        colors2.add(Color.ORANGE);
        colors2.add(Color.PURPLE);
        Result result = this.secretCombination.getResult(new ProposedCombination(colors2));
        assertThat(result.getBlacks(), is(2));
        assertThat(result.getWhites(), is(2));
}

@Test
public void testGetResultObtainBlackAndWhitesThenGet4BlacksAnd0Whites(){
    List<Color> colors2 = new ArrayList<>();
        colors2.add(Color.BLUE);
        colors2.add(Color.GREEN);
        colors2.add(Color.ORANGE);
        colors2.add(Color.PURPLE);
        Result result = this.secretCombination.getResult(new ProposedCombination(colors2));
        assertThat(result.getBlacks(), is(4));
        assertThat(result.getWhites(), is(0));
}

}