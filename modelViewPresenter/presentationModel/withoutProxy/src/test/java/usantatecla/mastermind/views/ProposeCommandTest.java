package usantatecla.mastermind.views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.mockito.InjectMocks;
import org.mockito.Mock;

import usantatecla.mastermind.controllers.PlayController;
import usantatecla.mastermind.models.Session;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProposeCommandTest {

    @Mock
    Console console;

    @InjectMocks
    ProposeCommand proposeCommand = new ProposeCommand(new PlayController(new Session(null),null));

    @BeforeEach
    void before() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testProposeCombinationAndVerifyResult(){
        try(MockedStatic console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            when(this.console.readString("Propose a combination: ")).thenReturn("ybop");
            assertThat(this.console.readString("Propose a combination: "), is("ybop"));
        }
    }
    
}
