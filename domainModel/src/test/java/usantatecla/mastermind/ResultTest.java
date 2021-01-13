package usantatecla.mastermind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

public class ResultTest {

    private static final int MIN_VALUE = 0;

    @Test
    public void testGivenOutOfBoundsParametersWhenConstructThenAssertionError() {
        Assertions.assertThrows(AssertionError.class, () -> new Result(ResultTest.MIN_VALUE - 1, ResultTest.MIN_VALUE));
        Assertions.assertThrows(AssertionError.class, () -> new Result(ResultTest.MIN_VALUE, ResultTest.MIN_VALUE - 1));
        Assertions.assertThrows(AssertionError.class, () -> new Result(Result.WIDTH + 1, ResultTest.MIN_VALUE));
        Assertions.assertThrows(AssertionError.class, () -> new Result(ResultTest.MIN_VALUE, Result.WIDTH + 1));
    }

    @Test
    public void testGivenWinnerResultWhenIsWinnerThenTrue() {
        assertThat(new Result(Result.WIDTH, ResultTest.MIN_VALUE).isWinner(), is(true));
    }

    @Test
    public void testGivenNotWinnerResultWhenIsWinnerThenFalse() {
        assertThat(new Result(Result.WIDTH - 1, ResultTest.MIN_VALUE + 1).isWinner(), is(false));
    }

    @Test
    void testGivenResultWhenWritelnThenPrint() {
        Console console = mock(Console.class);
        try (MockedStatic<Console> staticConsole = mockStatic(Console.class)) {
            staticConsole.when(Console::getInstance).thenReturn(console);
            new Result(Result.WIDTH, ResultTest.MIN_VALUE).writeln();
            verify(console).writeln(" --> 4 blacks and 0 whites");
        }
    }

}
