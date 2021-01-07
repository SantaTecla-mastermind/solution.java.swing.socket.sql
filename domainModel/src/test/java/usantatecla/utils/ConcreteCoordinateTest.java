package usantatecla.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ConcreteCoordinateTest {

    private ConcreteCoordinate coordinate;

    @Mock
    private Console console;

    @BeforeEach
    void before() {
        this.coordinate = new ConcreteCoordinate();
    }

    /*@Test
    public void testGivenConcreteCoordinateWhenReadThenChangeState() {
        int row = 1;
        int column = 1;
        when(console.readInt(anyString())).thenReturn(0, row, 4, column);
        assertThat(this.coordinate, is(new ConcreteCoordinate(row, column)));
    }*/

    @Test
    public void testGivenNewConcreteCoordinateWhenToString() {
        assertThat(this.coordinate.toString(), is("Coordinate (0, 0)"));
    }

    @Test
    public void testGivenNewConcreteCoordinateWhenIsNull() {
        assertThat(this.coordinate.isNull(), is(false));
    }

}
