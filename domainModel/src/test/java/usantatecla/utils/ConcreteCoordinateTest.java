package usantatecla.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

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
    public void testGivenConcreteCoordinateWhenGetRowAndGetColumn() {
        assertThat(this.coordinate, is(new ConcreteCoordinate(this.coordinate.getRow(), this.coordinate.getColumn())));
    }

    @Test
    public void testGivenNewConcreteCoordinateWhenToString() {
        assertThat(this.coordinate.toString(), is("Coordinate (0, 0)"));
    }

    @Test
    public void testGivenNewConcreteCoordinateWhenIsNull() {
        assertThat(this.coordinate.isNull(), is(false));
    }

    @Test
    public void testGivenTwoConcreteCoordinatesWhenAreInHorizontal() {
        ConcreteCoordinate coordinate1 = new ConcreteCoordinate(0,1);
        assertThat(this.coordinate.inHorizontal(coordinate1), is(true));
        assertThat(this.coordinate.getDirection(coordinate1), is(Direction.HORIZONTAL));
    }

    @Test
    public void testGivenTwoConcreteCoordinatesWhenAreInVertical() {
        ConcreteCoordinate coordinate1 = new ConcreteCoordinate(1,0);
        assertThat(this.coordinate.inVertical(coordinate1), is(true));
        assertThat(this.coordinate.getDirection(coordinate1), is(Direction.VERTICAL));
    }

    @Test
    public void testGivenNewConcreteCoordinateWhenIsInMainDiagonal() {
        ConcreteCoordinate coordinate1 = new ConcreteCoordinate(1,1);
        assertThat(this.coordinate.inMainDiagonal(), is(true));
        assertThat(this.coordinate.getDirection(coordinate1), is(Direction.MAIN_DIAGONAL));
    }

}
