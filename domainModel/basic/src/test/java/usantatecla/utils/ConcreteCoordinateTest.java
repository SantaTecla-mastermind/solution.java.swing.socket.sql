package usantatecla.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ConcreteCoordinateTest {

    @Mock
    private Console console;

    private Coordinate coordinate;

    @BeforeEach
    public void beforeEach() {
        this.coordinate = new ConcreteCoordinate(1, 1);
    }

    @Test
    public void testGivenCoordinateWhenIsNullThenIsFalse() {
        assertThat(this.coordinate.isNull(), is(false));
    }

    @Test
    public void testGivenCoordinateWhenGetDirectionThenValue() {
        assertThat(this.coordinate.getDirection(new ConcreteCoordinate(1, 2)), is(Direction.HORIZONTAL));
        assertThat(this.coordinate.getDirection(new ConcreteCoordinate(2, 1)), is(Direction.VERTICAL));
        assertThat(this.coordinate.getDirection(new ConcreteCoordinate(0, 0)), is(Direction.MAIN_DIAGONAL));
        assertThat(this.coordinate.getDirection(new ConcreteCoordinate(0, 2)), is(Direction.NULL));
        assertThat(this.coordinate.getDirection(this.coordinate), is(Direction.NULL));
        assertThat(this.coordinate.getDirection(Coordinate.NULL), is(Direction.NULL));
    }

    @Test
    public void testGivenCoordinateWhenInHorizontalThenValue() {
        assertThat(this.coordinate.inHorizontal(new ConcreteCoordinate(1, 2)), is(true));
        assertThat(this.coordinate.inHorizontal(new ConcreteCoordinate(0, 0)), is(false));
        assertThat(this.coordinate.inHorizontal(Coordinate.NULL), is(false));
    }

    @Test
    public void testGivenCoordinateWhenInVerticalThenValue() {
        assertThat(this.coordinate.inVertical(new ConcreteCoordinate(1, 0)), is(false));
        assertThat(this.coordinate.inVertical(new ConcreteCoordinate(2, 1)), is(true));
        assertThat(this.coordinate.inVertical(Coordinate.NULL), is(false));
    }

    @Test
    public void testGivenCoordinateWhenInMainDiagonalThenFalse() {
        assertThat(this.coordinate.inMainDiagonal(), is(true));
        assertThat(new ConcreteCoordinate(2, 1).inMainDiagonal(), is(false));
    }

    @Test
    public void testGivenEmptyCoordinatesWhenReadThenCorrectValues() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);

            final ConcreteCoordinate[] coordinates = {new ConcreteCoordinate(1, 2), new ConcreteCoordinate(0, 3)};
            for (int i = 0; i < coordinates.length; i++) {
                when(this.console.readInt(anyString())).thenReturn(coordinates[i].getRow() + 1, coordinates[i].getColumn() + 1);
                ConcreteCoordinate coordinate = new ConcreteCoordinate();
                coordinate.read("TITLE");

                assertThat(coordinate, is(coordinates[i]));
            }
        }
    }

    @Test
    public void testGivenCoordinateWhenIsEqualsThenReturn() {
        assertThat(this.coordinate.equals(new ConcreteCoordinate(1, 1)), is(true));
        assertThat(this.coordinate.equals(new ConcreteCoordinate(0, 1)), is(false));
        assertThat(this.coordinate.equals(Coordinate.NULL), is(false));
    }

    @Test
    public void testGivenCoordinateWhenToStringThenReturn() {
        assertThat(this.coordinate.toString(), is("Coordinate (1, 1)"));
    }

}
