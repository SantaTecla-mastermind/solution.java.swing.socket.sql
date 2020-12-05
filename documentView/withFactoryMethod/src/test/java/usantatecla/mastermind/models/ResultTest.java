package usantatecla.mastermind.models;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ResultTest {

    Result result;

    @Test
    void testGivenSomeResultsWhenGetBlackAndWhiteThenReturnsCorrectNumbers() {
        result = new Result(0, 0);
        assertThat(result.getBlacks(), is(0));
        assertThat(result.getWhites(), is(0));

        result = new Result(1, 2);
        assertThat(result.getBlacks(), is(1));
        assertThat(result.getWhites(), is(2));

        result = new Result(3, 1);
        assertThat(result.getBlacks(), is(3));
        assertThat(result.getWhites(), is(1));
    }

    @Test
    void testGivenResultWith2BlacksAnd2WhitesWhenIsWinnerThenReturnsFalse() {
        result = new Result(2, 2);
        assertThat(result.isWinner(), is(false));
    }

    @Test
    void testGivenResultWith4BlacksWhenIsWinnerThenReturnsTrue() {
        result = new Result(4, 0);
        assertThat(result.isWinner(), is(true));
    }
}
