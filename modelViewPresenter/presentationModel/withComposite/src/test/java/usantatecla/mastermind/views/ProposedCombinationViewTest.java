package usantatecla.mastermind.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usantatecla.utils.Console;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import usantatecla.mastermind.controllers.*;
import usantatecla.mastermind.models.Session;
import usantatecla.mastermind.models.ProposedCombination.Builder;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.models.ProposedCombination;

public class ProposedCombinationViewTest {

    @Mock
    Console console;

    @InjectMocks
    ProposedCombinationView ProposedCombitanionView;

    @BeforeEach
    void before() {
        this.console = mock(Console.class);
        this.ProposedCombitanionView = new ProposedCombinationView(new PlayController(new Session()));
    }

    @Test
    public void testGivenAProposedCombinationWhenReadThenIsCorrect() {
        // TODO No funciona el test, se queda cargando infinitamente. ¿Qué hay mal en el mock?
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