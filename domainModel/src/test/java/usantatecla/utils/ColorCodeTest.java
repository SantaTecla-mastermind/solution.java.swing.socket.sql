package usantatecla.utils;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ColorCodeTest {

    @Test
    void testGivenNewColorCodeWhenCallGetColorThenReturnCorrectStringColor() {
        ColorCode colorCode = ColorCode.BLUE;
        assertThat(colorCode.getColor(), is("\u001B[34m"));
    }

    @Test
    void testGivenAnIndexWhenCallGetColorByIndexThenReturnCorrectStringColor() {
        assertThat(ColorCode.getColorByIndex(0), is("\u001B[30m"));
    }
}
