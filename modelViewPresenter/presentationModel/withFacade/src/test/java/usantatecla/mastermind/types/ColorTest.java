package usantatecla.mastermind.types;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ColorTest {

    @Test
    public void testGivenInitialsWhenGetThenReturn() {
        assertThat(Color.get("rg"), is(new ArrayList<>(Arrays.asList(Color.RED, Color.GREEN))));
    }

    @Test
    public void testGivenInvalidInitialsWhenGetThenReturnNullColor() {
        assertThat(Color.get("ji"), is(new ArrayList<>(Arrays.asList(Color.NULL, Color.NULL))));
        assertThat(Color.get("ri"), is(new ArrayList<>(Arrays.asList(Color.RED, Color.NULL))));
        assertThat(Color.get("jc"), is(new ArrayList<>(Arrays.asList(Color.NULL, Color.CYAN))));
    }

    @Test
    public void testGivenColorWhenGetAllThenReturn() {
        assertThat(Color.getAll(), is(new ArrayList<>(Arrays.asList(
                Color.RED,
                Color.GREEN,
                Color.YELLOW,
                Color.BLUE,
                Color.MAGENTA,
                Color.CYAN
        ))));
    }

    @Test
    public void testGivenColorWhenGetAllInitialsThenReturn() {
        assertThat(Color.getAllInitials(), is("rgybmc"));
    }

    @Test
    public void testGivenColorWhenGetInitialThenReturn() {
        assertThat(Color.RED.getInitial(), is('r'));
        assertThat(Color.MAGENTA.getInitial(), is('m'));
        assertThat(Color.NULL.getInitial(), is('n'));
    }

    @Test
    public void testGivenColorWhenIsNullThenFalse() {
        assertThat(Color.RED.isNull(), is(false));
    }

    @Test
    public void testGivenNullColorWhenIsNullThenTrue() {
        assertThat(Color.NULL.isNull(), is(true));
    }

}
