package usantatecla.mastermind.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.views.ViewFactory;
import usantatecla.mastermind.views.console.ResumeView;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ResumeControllerTest  {

    @Mock
    private ResumeView resumeView;

    @Mock
    private ViewFactory viewFactory;

    private ResumeController resumeController;

    @BeforeEach
    public void beforeEach() {
        this.resumeController = new ResumeController(new Board(), this.viewFactory);
    }

    @Test
    public void testGivenResumeControllerWhenControlThenReturnFalse() {
        when(this.viewFactory.createResumeView()).thenReturn(this.resumeView);
        when(this.resumeView.read()).thenReturn(false);
        assertThat(this.resumeController.control(), is(false));
    }

    @Test
    public void testGivenResumeControllerWhenControlThenReturnTrue() {
        when(this.viewFactory.createResumeView()).thenReturn(this.resumeView);
        when(this.resumeView.read()).thenReturn(true);
        assertThat(this.resumeController.control(), is(true));
    }

}
