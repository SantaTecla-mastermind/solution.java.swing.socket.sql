package usantatecla.mastermind.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StateTest {

    private State state;

    @BeforeEach
    public void beforeEach() {
        this.state = new State();
    }

    @Test
    public void testGivenNewStateWhenResetThenStateValueIsINITIAL() {
        this.state.reset();
        assertThat(this.state.getValueState(), is(StateValue.INITIAL));
    }

    @Test
    public void testGivenNewStateWhenNextThenStateValueIsIN_GAME() {
        this.state.next();
        assertThat(this.state.getValueState(), is(StateValue.IN_GAME));
    }
}
