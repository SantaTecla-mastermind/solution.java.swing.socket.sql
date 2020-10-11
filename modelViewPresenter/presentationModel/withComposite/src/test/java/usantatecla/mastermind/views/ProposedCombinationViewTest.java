package usantatecla.mastermind.views;

import usantatecla.utils.Console;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import usantatecla.mastermind.controllers.*;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.ProposedCombination.Builder;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.models.ProposedCombination;

@RunWith(MockitoJUnitRunner.class)
public class ProposedCombinationViewTest {

    @Mock
    Console console;

    @InjectMocks
    ProposedCombinationView ProposedCombitanionView = new ProposedCombinationView(new PlayController(new Session()));

    @Test
    public void testGivenAProposedCombinationWhenReadThenIsCorrect() {
        when(this.console.readString("Propose a combination: ")).thenReturn("ybop");
        List<Color> proposedCombination = this.ProposedCombitanionView.read();
        List<Color> proposedCombinationExpected = ProposedCombination.builder().colors("ybop").build();
        System.out.println(proposedCombination);
        System.out.println(proposedCombinationExpected);
        assertEquals(proposedCombination, proposedCombinationExpected);
        
    }

    @Test
    public void testGivenAProposedCombinationWhenReadThenIsIncorrect() {
        when(this.console.readString("Propose a combination: ")).thenReturn("yyop");
        this.ProposedCombitanionView.read();
        verify(this.console).readString("Propose a combination: ");
    }

}