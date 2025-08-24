package Klassen;

public class Triangle {
    // Eckpunkte des Dreiecks
    private Point A;
    private Point B;
    private Point C;

    // Konstruktor
    public Triangle(Point A, Point B, Point C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }

    // Hilfsmethoden: Seitenlängen
    private double sideAB() {
        return A.distanceTo(B);
    }

    private double sideBC() {
        return B.distanceTo(C);
    }

    private double sideCA() {
        return C.distanceTo(A);
    }

    // Hilfsmethode: Vergleich mit Toleranz (wegen Gleitkommaungenauigkeit)
    private boolean nearlyEqual(double a, double b) {
        double eps = 1e-9;
        return Math.abs(a - b) < eps;
    }

    // gleichseitig: alle drei Seiten gleich lang
    public boolean isEquilateral() {
        double ab = sideAB();
        double bc = sideBC();
        double ca = sideCA();
        return nearlyEqual(ab, bc) && nearlyEqual(bc, ca);
    }

    // gleichschenklig: mindestens zwei Seiten gleich lang
    public boolean isIsosceles() {
        double ab = sideAB();
        double bc = sideBC();
        double ca = sideCA();
        return nearlyEqual(ab, bc) || nearlyEqual(bc, ca) || nearlyEqual(ca, ab);
    }

    // Hilfsmethode: prüft auf spitz/recht/stumpfwinklig anhand der Längensätze
    private int angleType() {
        double ab = sideAB();
        double bc = sideBC();
        double ca = sideCA();

        // größte Seite finden (gegenüber größtem Winkel)
        double[] sides = {ab, bc, ca};
        java.util.Arrays.sort(sides);
        double a = sides[0];
        double b = sides[1];
        double c = sides[2]; // längste Seite

        double lhs = a * a + b * b;
        double rhs = c * c;

        if (nearlyEqual(lhs, rhs)) {
            return 0; // rechtwinklig
        } else if (lhs > rhs) {
            return -1; // spitzwinklig
        } else {
            return 1; // stumpfwinklig
        }
    }

    public boolean isRight() {
        return angleType() == 0;
    }

    public boolean isAcute() {
        return angleType() == -1;
    }

    public boolean isObtuse() {
        return angleType() == 1;
    }
}
