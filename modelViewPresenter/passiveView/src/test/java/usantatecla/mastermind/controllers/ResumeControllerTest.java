package usantatecla.mastermind.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.models.Board;
import usantatecla.mastermind.models.BoardBuilder;
import usantatecla.mastermind.views.console.ResumeView;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ResumeControllerTest extends ControllerTest{

    @Mock
    private ResumeView resumeView;

    @Override
    protected Controller getController(int blacks, int whites, List<String> proposedCombinations) {
        return new ResumeController(new BoardBuilder()
                .blacks(blacks).whites(whites)
                .proposedCombinations(proposedCombinations)
                .build(), this.viewFactory);
    }

    @Test
    public void testGivenResumeControllerWhenControlThenReturnFalse() {
        when(this.viewFactory.createResumeView()).thenReturn(this.resumeView);
        when(this.resumeView.read()).thenReturn(false);
        this.controller = new ResumeController(new Board(), this.viewFactory);
        assertThat(((ResumeController) this.controller).control(), is(false));
    }

    @Test
    public void testGivenResumeControllerWhenControlThenReturnTrue() {
        when(this.viewFactory.createResumeView()).thenReturn(this.resumeView);
        when(this.resumeView.read()).thenReturn(true);
        this.controller = new ResumeController(new Board(), this.viewFactory);
        assertThat(((ResumeController) this.controller).control(), is(true));
    }


}
