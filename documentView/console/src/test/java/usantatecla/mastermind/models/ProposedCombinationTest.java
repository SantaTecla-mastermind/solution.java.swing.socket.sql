package usantatecla.mastermind.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.ColorCode;
import usantatecla.utils.Console;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProposedCombinationTest {

    private ProposedCombination proposedCombination;

    @Mock
    Console console;

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
