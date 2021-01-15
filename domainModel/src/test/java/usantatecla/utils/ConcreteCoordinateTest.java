package usantatecla.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConcreteCoordinateTest {

    @Mock
    Console console;

    private Coordinate coordinate;
    private int row;
    private int column;

    @BeforeEach
    public void beforeEach() {
        this.row = 270;
        this.column = -167;
        this.coordinate = new ConcreteCoordinate(row, column);
    }

    @Test
    public void testGivenCoordinateWhenIsNullThenIsFalse() {
        assertThat(this.coordinate.isNull(), is(false));
    }

    @Test
    public void testGivenCoordinateWhenGetDirectionThenValue() {
        assertThat(this.coordinate.getDirection(new ConcreteCoordinate(row, column + 1)), is(Direction.HORIZONTAL));
        assertThat(this.coordinate.getDirection(new ConcreteCoordinate(row + 1, column)), is(Direction.VERTICAL));
        assertThat(this.coordinate.getDirection(new ConcreteCoordinate(row - 1, column - 1)), is(Direction.MAIN_DIAGONAL));
        assertThat(this.coordinate.getDirection(new ConcreteCoordinate(row - 1, column + 1)), is(Direction.NULL));
        assertThat(this.coordinate.getDirection(this.coordinate), is(Direction.NULL));
        assertThat(this.coordinate.getDirection(Coordinate.NULL), is(Direction.NULL));
    }

    //TODO cambiar con row y column
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
    public void testGivenCoordinateWhenInMainDiagonalThenValue() {
        assertThat(this.coordinate.inMainDiagonal(), is(true));
        assertThat(new ConcreteCoordinate(2, 1).inMainDiagonal(), is(false));
    }

    @Test
    public void testGivenEmptyCoordinatesWhenReadThenCorrectValues() {
        try (MockedStatic<Console> console = mockStatic(Console.class)) {
            console.when(Console::getInstance).thenReturn(this.console);

            ConcreteCoordinate coordinate = new ConcreteCoordinate(-127, 333);
            when(this.console.readInt(anyString())).thenReturn(coordinate.getRow() + 1, coordinate.getColumn() + 1);
            ConcreteCoordinate coordinateSut = new ConcreteCoordinate();
            coordinateSut.read("TITLE");

            assertThat(coordinateSut, is(coordinate));
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
