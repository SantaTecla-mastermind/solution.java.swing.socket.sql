package usantatecla.mastermind;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ErrorTest {
    @Test
    public void testColorIsNull(){
        Error error = Error.NULL;
        assertTrue(error.isNull());
    }
}
