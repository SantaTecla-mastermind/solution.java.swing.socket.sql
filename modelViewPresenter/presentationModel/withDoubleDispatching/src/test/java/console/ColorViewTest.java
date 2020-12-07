package console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.mastermind.types.Color;
import usantatecla.mastermind.views.console.ColorView;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ColorViewTest {

    @Mock
    Console console;

    ColorView colorView;

    @BeforeEach
    void before() {
        this.colorView = new ColorView();
    }

    @Test
    void testGivenStaticMethodAllInitialsWhenCallingThatMethodThenReturnsCorrectString() {
        String reset_color = "\u001B[0m";
        assertThat(this.colorView.allInitials(), is("\u001B[31mr" + reset_color +
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
        this.colorView = new ColorView(Color.GREEN);

        ArgumentCaptor<String> completeColorCode = ArgumentCaptor.forClass(String.class);

        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.colorView.write();
            verify(this.console).write(completeColorCode.capture());
            assertThat(completeColorCode.getValue(), is("\u001B[32m" + "g" + "\u001B[0m"));
        }
    }

    @Test
    void testGivenNullColorWhenWriteThenNothingHappen() {
        this.colorView = new ColorView(Color.NULL);

        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);
            this.colorView.write();
            verify(this.console, never()).write(anyString());
        }

    }
}
