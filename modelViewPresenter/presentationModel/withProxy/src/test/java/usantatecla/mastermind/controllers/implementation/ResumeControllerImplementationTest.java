package usantatecla.mastermind.controllers.implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.verify;

public class ResumeControllerImplementationTest extends AcceptorControllerImplementationTest {

    @BeforeEach
    public void beforeEach() {
        this.acceptorController = new ResumeControllerImplementation(this.session);
    }

    @Test
    public void testGivenResumeControllerImplementationWhenResetThenCorrect() {
        ((ResumeControllerImplementation) this.acceptorController).reset();
        verify(this.session).reset();
    }

}
