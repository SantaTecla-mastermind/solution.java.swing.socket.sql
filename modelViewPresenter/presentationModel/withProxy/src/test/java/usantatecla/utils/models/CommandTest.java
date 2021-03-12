package usantatecla.utils.models;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class CommandTest {
    
    private static final String TITLE = "Command Title";

    public Command getCommand() {
        return new Command(CommandTest.TITLE) {

            @Override
            public void execute() {
            }

            @Override
            public boolean isActive() {
                return true;
            }
            
        };
    }

    @Test
	public void testGivenCommandWhenIsActiveThenTrue() {
        assertThat(this.getCommand().isActive(), is(this.isActive()));
    }

    public boolean isActive() {
        return true;
    }

    @Test
	public void testGivenCommandWhenGetTitleThenReturn() {
		assertThat(this.getCommand().getTitle(), is(this.getTitle()));
	}

    public String getTitle() {
        return CommandTest.TITLE;
    }

}
