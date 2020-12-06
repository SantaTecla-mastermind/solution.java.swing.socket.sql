package usantatecla.mastermind.views;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.types.Color;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ColorViewTest {

    @Mock
    Console console;

    ColorView colorView;

    @Test
    void testGivenStaticMethodAllInitialsWhenCallingThatMethodThenReturnsCorrectString() {
        String reset_color = "\u001B[0m";
        assertThat(ColorView.allInitials(), is("\u001B[31mr" + reset_color +
                "\u001B[34mb" + reset_color +
                "\u001B[33my" + reset_color +
                "\u001B[32mg" + reset_color +
                "\u001B[37mo" + reset_color +
                "\u001B[35mp" + reset_color));
    }

    @Test
    void testGivenNotMatchingInitialColorCharacterWhenGetInstanceThenReturnsNullColor() {
        assertThat(ColorView.getInstance('n'), is(Color.NULL));
    }

    @Test
    void testGivenMatchingInitialColorCharacterWhenGetInstanceThenReturnsCorrectColor() {
        assertThat(ColorView.getInstance('g'), is(Color.GREEN));
    }

    @Test
    void testGivenAColorWhenWriteThenCapturesCorrectArguments() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            this.colorView = new ColorView(Color.GREEN);
            console.when(Console::getInstance).thenReturn(this.console);
            this.colorView.write();
            verify(this.console).write("\u001B[32m" + "g" + "\u001B[0m");
        }
    }

    @Test
    void testGivenNullColorWhenWriteThenNothingHappen() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            this.colorView = new ColorView(Color.NULL);
            console.when(Console::getInstance).thenReturn(this.console);
            this.colorView.write();
            verify(this.console, never()).write(anyString());
        }
    }
}
