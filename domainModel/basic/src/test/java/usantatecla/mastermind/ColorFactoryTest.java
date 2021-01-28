package usantatecla.mastermind;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usantatecla.utils.ColorCode;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ColorFactoryTest {

    private ColorFactory colorFactory;

    @BeforeEach
    public void beforeEach() {
        this.colorFactory = ColorFactory.getInstance();
    }

    @Test
    public void testGivenColorFactoryWhenGetInitialsThenAllInitials() {
        assertThat(this.colorFactory.getInitials(), is("rgybmc"));
    }

    @Test
    public void testGivenColorFactoryWhenGetColorByCharacterThenColorCode() {
        assertThat(this.colorFactory.getColorCode('r'), is(ColorCode.RED));
    }

    @Test
    public void testGivenColorFactoryWhenGetColorByCharacterThenColorCodeNull() {
        assertThat(this.colorFactory.getColorCode('l'), is(ColorCode.NULL));
    }

    @Test
    public void testGivenColorFactoryWhenGetColorCodesWithSomeWrongCharactersThenReturnOnlyMatchingColors() {
        List<ColorCode> colorCodes = Arrays.asList(
                ColorCode.GREEN,
                ColorCode.BLUE,
                ColorCode.YELLOW,
                ColorCode.CYAN);
        assertThat(this.colorFactory.getColorCodes("tgbych"), is(colorCodes));
    }

    @Test
    public void testGivenColorFactoryWhenGetAllColorsThenReturn() {
        List<ColorCode> colorCodes = Arrays.asList(ColorCode.RED,
                ColorCode.GREEN,
                ColorCode.YELLOW,
                ColorCode.BLUE,
                ColorCode.MAGENTA,
                ColorCode.CYAN);
        assertThat(this.colorFactory.getAllColorCodes(), is(colorCodes));
    }

}
