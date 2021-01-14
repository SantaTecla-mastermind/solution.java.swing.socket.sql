package usantatecla.mastermind.models;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ErrorTest {

    @Mock
    Console console;

    @Test
    public void testGivenNullErrorWhenIsNullThenTrue() {
        assertThat(Error.NULL.isNull(), is(true));
    }

}
