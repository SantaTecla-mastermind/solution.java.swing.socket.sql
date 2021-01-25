package usantatecla.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ClosedIntervalTest {

    private final int MIN = -1;
    private final int MAX = 1;
    private ClosedInterval closedInterval;


    @BeforeEach
    void beforeEach() {
        this.closedInterval = new ClosedInterval(MIN, MAX);
    }

    @Test
    public void testGivenClosedIntervalWhenIsIncludeThenOk() {
        assertThat(this.closedInterval.isIncluded(MIN), is(true));
        assertThat(this.closedInterval.isIncluded(MIN + 1), is(true));
        assertThat(this.closedInterval.isIncluded(MAX), is(true));
    }

    @Test
    public void testGivenClosedIntervalWhenIsIncludeThenNotOk() {
        assertThat(this.closedInterval.isIncluded(MIN - 1), is(false));
        assertThat(this.closedInterval.isIncluded(MAX + 1), is(false));
    }

    @Test
    public void testGivenClosedIntervalWhenToStringThenOk() {
        assertThat(this.closedInterval.toString(), is("[" + MIN + ", " + MAX + "]"));
    }

}
