package usantatecla.mastermind;

class Result {

    public static final int WIDTH = 4;
    private int blacks;
    private int whites;

    Result(int blacks, int whites) {
        assert blacks >= 0 && blacks <= Result.WIDTH;
        assert whites >= 0 && whites <= Result.WIDTH;

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
