package usantatecla.mastermind;

import usantatecla.utils.ClosedInterval;

class Result {

    public static final int WIDTH = 4;
    private static final ClosedInterval LIMITS = new ClosedInterval(0,Result.WIDTH);
    private int blacks;
    private int whites;

    Result(int blacks, int whites) {
        assert Result.LIMITS.isIncluded(blacks);
        assert Result.LIMITS.isIncluded(whites);

        this.blacks = blacks;
        this.whites = whites;
    }

    boolean isWinner() {
        return this.blacks == Result.WIDTH;
    }

    void writeln() {
        Message.RESULT.writeln(this.blacks, this.whites);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Result other = (Result) obj;
        if (this.blacks != other.blacks)
            return false;
        if (this.whites != other.whites)
            return false;
        return true;
    }

}
