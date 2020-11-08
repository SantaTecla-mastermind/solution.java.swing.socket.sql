package usantatecla.mastermind.views;

import org.junit.jupiter.api.Test;
import usantatecla.utils.*;

import static org.mockito.Mockito.when;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.models.Session;

public class ProposeCommandTest {

    @Mock
    Console console;

    @InjectMocks
    ProposeCommand proposeCommand = new ProposeCommand(new PlayController(new Session()));

    @Test
    public void testProposeCombinationAndVerifyResult(){
        //when(this.console.readString("Propose a combination: ")).thenReturn("ybop");
       // when(this.console.readString("Propose a combination: ")).thenReturn("ybop");
        //this.proposeCommand.execute();
    }
    
}