package Klassen;

public class Triangle {

    private Point A;
    private Point B;
    private Point C;


    public Triangle(Point A, Point B, Point C) {
        this.A = A;
        this.B = B;
        this.C = C;
    }


    private double sideAB() {
        return A.distanceTo(B);
    }

    private double sideBC() {
        return B.distanceTo(C);
    }

    private double sideCA() {
        return C.distanceTo(A);
    }


    private boolean nearlyEqual(double a, double b) {
        double eps = 1e-9;
        return Math.abs(a - b) < eps;
    }


    public boolean isEquilateral() {
        double ab = sideAB();
        double bc = sideBC();
        double ca = sideCA();
        return nearlyEqual(ab, bc) && nearlyEqual(bc, ca);
    }


    public boolean isIsosceles() {
        double ab = sideAB();
        double bc = sideBC();
        double ca = sideCA();
        return nearlyEqual(ab, bc) || nearlyEqual(bc, ca) || nearlyEqual(ca, ab);
    }


    private int angleType() {
        double ab = sideAB();
        double bc = sideBC();
        double ca = sideCA();


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
