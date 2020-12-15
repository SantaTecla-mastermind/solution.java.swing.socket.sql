package usantatecla.mastermind.controllers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.types.Error;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@ExtendWith(MockitoExtension.class)
public class ProposalControllerTest {

    ProposalController proposalController = new ProposalController(new Game());

    @Test
    void testGivenWrongWidthColorListWhenAddProposedCombinationThenCorrectErrorIsReturned() {
        List<Color> colors = new ArrayList<>(Arrays.asList(Color.BLUE, Color.GREEN, Color.ORANGE, Color.PURPLE, Color.RED));
        assertThat(this.proposalController.addProposedCombination(colors), is(Error.WRONG_LENGTH));
    }

    @Test
    void testGivenWrongColorWhenAddProposedCombinationThenCorrectErrorIsReturned() {
        List<Color> colors = new ArrayList<>(Arrays.asList(Color.BLUE, Color.GREEN, Color.ORANGE, Color.NULL));
        assertThat(this.proposalController.addProposedCombination(colors), is(Error.WRONG_CHARACTERS));
    }

    @Test
    void testGivenDuplicatedColorsWhenAddProposedCombinationThenCorrectErrorIsReturned() {
        List<Color> colors = new ArrayList<>(Arrays.asList(Color.BLUE, Color.BLUE, Color.ORANGE, Color.PURPLE));
        assertThat(this.proposalController.addProposedCombination(colors), is(Error.DUPLICATED));
    }

    @Test
    void testGivenCorrectColorsWhenAddProposedCombinationThenNullErrorIsReturned() {
        List<Color> colors = new ArrayList<>(Arrays.asList(Color.RED, Color.BLUE, Color.ORANGE, Color.PURPLE));
        assertThat(this.proposalController.addProposedCombination(colors), is(Error.NULL));
    }

}
