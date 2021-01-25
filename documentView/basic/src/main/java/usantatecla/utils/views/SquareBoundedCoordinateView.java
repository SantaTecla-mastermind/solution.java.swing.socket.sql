package usantatecla.utils.views;

import usantatecla.utils.models.ConcreteCoordinate;
import usantatecla.utils.models.SquaredBoundedCoordinate;

public abstract class SquareBoundedCoordinateView {

    public SquaredBoundedCoordinate read(String message) {
        assert message != null;

        boolean error;
        SquaredBoundedCoordinate squaredBoundedCoordinate;
        do {
            ConcreteCoordinate concreteCoordinate = new ConcreteCoordinateView().read(message);
            squaredBoundedCoordinate = this.createCoordinate(concreteCoordinate);

            error = !squaredBoundedCoordinate.isValid();
            if (error) {
                Console.getInstance().writeln(this.getErrorMessage());
            }
        } while (error);
        return squaredBoundedCoordinate;
    }

    public abstract SquaredBoundedCoordinate createCoordinate(ConcreteCoordinate concreteCoordinate);

    public abstract String getErrorMessage();

}
