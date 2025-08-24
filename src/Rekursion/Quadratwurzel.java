package Rekursion;

public class Quadratwurzel {

    public static double quadratwurzel(double x, int n) {

        double x0 = (x + 1) / 2;


        return quadratwurzelRekursiv(x, x0, n);
    }

    private static double quadratwurzelRekursiv(double x, double xn, int n) {
        if (n == 0) {

            return xn;
        } else {

            double xn1 = 0.5 * (xn + x / xn);
            return quadratwurzelRekursiv(x, xn1, n - 1);
        }
    }


    public static void main(String[] args) {
        double zahl = 25.0;
        int rekursionstiefe = 10;
        double wurzel = quadratwurzel(zahl, rekursionstiefe);
        System.out.println("Annäherung der Quadratwurzel von " + zahl + ": " + wurzel);
    }
}
