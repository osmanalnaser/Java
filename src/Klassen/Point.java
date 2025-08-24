package Klassen;

public class Point {

    private double x;
    private double y;


    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }


    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }


    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }


    public double distanceTo(Point other) {
        double dx = this.x - other.x;
        double dy = this.y - other.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Verschieben des Punktes
    public void shift(double xShift, double yShift) {
        this.x += xShift;
        this.y += yShift;
    }


    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
