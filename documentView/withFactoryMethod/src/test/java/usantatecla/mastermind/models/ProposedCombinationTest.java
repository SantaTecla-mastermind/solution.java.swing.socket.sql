package usantatecla.mastermind.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ProposedCombinationTest {

    private ProposedCombination proposedCombination;

    @BeforeEach
    void before() {
        this.proposedCombination = new ProposedCombination();
    }

    @Test
    void testGivenEmptyProposedCombinationWhenGetColorsLengthThenReturns0() {
        assertThat(this.proposedCombination.getColors().size(), is(0));
    }

    @Test
    void testGivenColorsInProposedCombinationWhenIsEqualsToOtherColorArrayThenIsTrue() {
        ArrayList<Color> colors = new ArrayList<>(Arrays.asList(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW));
        this.proposedCombination.colors = colors;

        assertThat(this.proposedCombination.getColors(), is(equalTo(colors)));
    }

    @Test
    void testGivenColorsInProposedCombinationWhenColorIsNotContainedThenIsFalse() {
        ArrayList<Color> colors = new ArrayList<>(Arrays.asList(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW));
        this.proposedCombination.colors = colors;

        assertThat(this.proposedCombination.getColors().contains(Color.PURPLE), is(false));
    }
}
