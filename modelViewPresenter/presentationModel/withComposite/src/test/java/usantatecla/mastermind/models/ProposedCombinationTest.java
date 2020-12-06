package usantatecla.mastermind.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usantatecla.mastermind.types.Color;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class ProposedCombinationTest {

    private ProposedCombination proposedCombination;
    private ArrayList<Color> colors;

    @BeforeEach
    void before() {
        colors = new ArrayList<>(Arrays.asList(Color.RED, Color.BLUE, Color.GREEN, Color.YELLOW));
        this.proposedCombination = new ProposedCombination(this.colors);
    }

    @Test
    void testGivenEmptyProposedCombinationWhenGetColorsLengthThenReturns0() {
        assertThat(this.proposedCombination.colors.size(), is(4));
    }

    @Test
    void testGivenColorsInProposedCombinationWhenIsEqualsToOtherColorArrayThenIsTrue() {
        this.proposedCombination.colors = this.colors;
        assertThat(this.proposedCombination.colors, is(equalTo(this.colors)));
    }

    @Test
    void testGivenColorsInProposedCombinationWhenColorIsNotContainedThenIsFalse() {
        this.proposedCombination.colors = colors;
        assertThat(this.proposedCombination.colors.contains(Color.PURPLE), is(false));
    }
}
