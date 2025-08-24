package Klassen;

public class Point {
    // Attribute
    private double x;
    private double y;

    // Konstruktor
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getter
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Setter
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    // Abstand zu einem anderen Punkt
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

    // Für bessere Ausgabe
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
