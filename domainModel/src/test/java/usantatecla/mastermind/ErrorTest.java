package usantatecla.mastermind;

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
    private Console console;

    @Test
    public void testGivenErrorWhenWritelnThenWrite() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            Error.DUPLICATED.writeln();
            verify(this.console).writeln("Repeated colorFactories");
        }
    }

    @Test
    public void testGivenNullErrorWhenIsNullThenTrue() {
        assertThat(Error.NULL.isNull(), is(true));
    }

    @Test
    public void testGivenNotNullErrorWhenIsNullThenFalse() {
        assertThat(Error.DUPLICATED.isNull(), is(false));
    }

}
