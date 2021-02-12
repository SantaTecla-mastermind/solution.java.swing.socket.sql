package usantatecla.mastermind.views;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MessageTest {

    @Test
    public void testGivenNewMessageWhenToString() {
        assertThat(Message.RESUME.toString(), is("Do you want to continue"));
    }

}
