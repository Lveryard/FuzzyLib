public class Point {

    Double X, Y;

    public Point(Double x, Double y) {
        X = x;
        Y = y;
    }

    @Override
    public String toString() {
        return "( " + X + "," + Y + " )";
    }
}
