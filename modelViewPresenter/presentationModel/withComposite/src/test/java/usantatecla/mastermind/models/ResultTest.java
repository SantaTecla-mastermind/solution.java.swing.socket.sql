package usantatecla.mastermind.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ResultTest {
    private Result result;

    public ResultTest(){
        this.result = new Result(2, 1);
    }

    @Test
    public void testGetBlacksThenGet2(){
        assertEquals(2,this.result.getBlacks());
    }

    @Test
    public void testGetWhitesThenGet1(){
        assertEquals(1,this.result.getWhites());
    }

    @Test
    public void testCopyResult(){
        Result resultcopy = this.result.copy();
        assertEquals(this.result.getBlacks(), resultcopy.getBlacks());
        assertEquals(this.result.getWhites(), resultcopy.getWhites());
    }

    @Test
    public void testIsWinnerThenReturnFalse(){
        assertFalse(this.result.isWinner());
    }

    @Test
    public void testIsWinnerThenReturnTrue(){
        Result result2 = new Result(4,0);
        assertTrue(result2.isWinner());
    }

}