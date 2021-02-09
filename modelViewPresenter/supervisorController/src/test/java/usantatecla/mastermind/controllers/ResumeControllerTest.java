package usantatecla.mastermind.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.console.ResumeView;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ResumeControllerTest extends ControllerTest {

    @Mock
    private ResumeView resumeView;

    @BeforeEach
    public void beforeEach() {
        this.board = new Board();
        this.controller = new ResumeController(this.board, this.viewFactory);
    }

    @Test
    public void testGivenResumeControllerWhenControlThenReturnFalse() {
        when(this.viewFactory.createResumeView()).thenReturn(this.resumeView);
        when(this.resumeView.read()).thenReturn(false);
        assertThat(((ResumeController) this.controller).control(), is(false));
    }

    @Test
    public void testGivenResumeControllerWhenControlThenReturnTrue() {
        when(this.viewFactory.createResumeView()).thenReturn(this.resumeView);
        when(this.resumeView.read()).thenReturn(true);
        assertThat(((ResumeController) this.controller).control(), is(true));
    }


}
