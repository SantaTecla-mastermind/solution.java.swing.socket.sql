package usantatecla.mastermind;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import usantatecla.utils.Console;
import java.io.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.in;
import static org.hamcrest.Matchers.is;

public class MessageTest {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    Console console;

    @BeforeEach
    public void before() {
        System.setOut(new PrintStream(output));
        this.console = Console.getInstance();
    }

    @Test
    public void testGivenNewMessageWhenToString() {
        assertThat(Message.RESUME.toString(), is("Do you want to continue"));
    }

    @Test
    public void testGivenNewMessageWhenWrite(){
        Message.PROPOSED_COMBINATION.write();
        assertThat(Message.PROPOSED_COMBINATION.toString(), is(output.toString()));
    }

    @Test
    public void testGivenNewMessageWhenWritelnWithoutParams(){
        String newLine = System.getProperty("line.separator");
        Message.PROPOSED_COMBINATION.writeln();
        assertThat(Message.PROPOSED_COMBINATION.toString()+newLine, is(output.toString()));
    }

    @Test
    public void testGivenNewMessageWhenWritelnWithParams(){
        int attempts = 5;
        String newLine = System.getProperty("line.separator");
        Message.ATTEMPTS.writeln(attempts);
        assertThat(Message.ATTEMPTS.toString().replaceAll("#attempts", "" + attempts)+newLine, is(output.toString()));
    }
}
