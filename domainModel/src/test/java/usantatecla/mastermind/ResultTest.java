package usantatecla.mastermind;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ResultTest {

    @Test
    public void testColorIsNull(){
        Result result = new Result(4, 0);
        assertTrue(result.isWinner());
    }
}
