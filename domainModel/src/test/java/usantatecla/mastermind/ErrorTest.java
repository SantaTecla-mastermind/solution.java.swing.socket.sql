package usantatecla.mastermind;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ErrorTest {
    @Test
    public void testColorIsNull(){
        Error error = Error.NULL_ERROR;
        assertTrue(error.isNull());
    }
}
