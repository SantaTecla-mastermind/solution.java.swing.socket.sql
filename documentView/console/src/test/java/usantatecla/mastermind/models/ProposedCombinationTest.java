package usantatecla.mastermind.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.ColorCode;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
public class ProposedCombinationTest {

    private ProposedCombination proposedCombination;

    @BeforeEach
    void beforeEach() {
        this.proposedCombination = new ProposedCombination();
    }

    @Test
    void testGivenEmptyProposedCombinationThenNotContainAnyColor() {
        List<ColorCode> colorCodes = ColorFactory.getInstance().getAllColorCodes();
        for (ColorCode colorCode : colorCodes) {
            assertThat(this.proposedCombination.contains(colorCode), is(false));
        }
    }

}
