package usantatecla.mastermind;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
