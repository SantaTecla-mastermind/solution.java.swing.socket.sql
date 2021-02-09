package usantatecla.mastermind.views;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
public class MessageTest {

    @Test
    public void testGivenNewMessageWhenToStringThenReturn() {
        assertThat(Message.PROPOSED_COMBINATION.toString(), is("Propose a combination: "));
    }

}
