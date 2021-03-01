package usantatecla.mastermind.models;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ResultTest {
    private Result result;

    public ResultTest(){
        this.result = new Result(2, 1);
    }

    @Test
    public void testGetBlacksThenGet2(){
        assertThat(this.result.getBlacks(), is(2));
    }

    @Test
    public void testGetWhitesThenGet1(){
        assertThat(this.result.getWhites(), is(1));
    }

    @Test
    public void testCopyResult(){
        Result resultcopy = this.result.copy();
        assertThat(resultcopy.getBlacks(), is(this.result.getBlacks()));
        assertThat(resultcopy.getWhites(), is(this.result.getWhites()));
    }

    @Test
    public void testIsWinnerThenReturnFalse(){
        assertThat(this.result.isWinner(), is(false));
    }

    @Test
    public void testIsWinnerThenReturnTrue(){
        Result result2 = new Result(4,0);
        assertThat(result2.isWinner(), is(true));
    }

}