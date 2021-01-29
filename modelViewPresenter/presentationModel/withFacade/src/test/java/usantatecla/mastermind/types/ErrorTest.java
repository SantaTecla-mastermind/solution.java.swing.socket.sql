package usantatecla.mastermind.types;

import org.junit.jupiter.api.Test;

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
