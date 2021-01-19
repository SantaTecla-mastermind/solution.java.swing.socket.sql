package usantatecla.mastermind.models;

import org.junit.jupiter.api.Test;
import usantatecla.mastermind.types.Error;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ErrorTest {

    @Test
    public void testGivenNullErrorWhenIsNullThenTrue() {
        assertThat(Error.NULL.isNull(), is(true));
    }

    @Test
    public void testGivenNotNullErrorWhenIsNullThenFalse() {
        assertThat(Error.DUPLICATED.isNull(), is(false));
    }

}
