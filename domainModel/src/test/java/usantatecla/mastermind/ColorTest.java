package usantatecla.mastermind;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ColorTest {

    @Test
    public void testGetInstanceColorByCharacterGiven(){
        assertEquals(Color.get(0), Color.getInstance('r'));
    }

    @Test
    public void testGetColorsInitials(){
        String[] colors = Color.getInitials().split("0m");
        assertEquals(Color.length(), colors.length);
    }

    @Test
    public void testColorIsNull(){
        Color color = Color.getInstance('w');
        assertTrue(color.isNull());
    }
}
