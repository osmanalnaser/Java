package Klassen;

public class Fraction {
    private int nominator;
    private int denominator;

    // Konstruktor mit Zähler und Nenner
    public Fraction(int nominator, int denominator) {
        this.nominator = nominator;
        if (denominator == 0) {
            this.denominator = 1; // Nenner darf nicht 0 sein
        } else {
            this.denominator = denominator;
        }
    }

    // Konstruktor für eine ganze Zahl
    public Fraction(int n) {
        this.nominator = n;
        this.denominator = 1;
    }

    // Multiplikation mit einem anderen Bruch
    public void multiply(Fraction factor) {
        this.nominator = this.nominator * factor.nominator;
        this.denominator = this.denominator * factor.denominator;
    }

    // Addition mit einem anderen Bruch
    public void add(Fraction summand) {
        this.nominator = this.nominator * summand.denominator
                + summand.nominator * this.denominator;
        this.denominator = this.denominator * summand.denominator;
    }

    // Rückgabe als String
    @Override
    public String toString() {
        return nominator + "/" + denominator;
    }

    // Rückgabe als double
    public double asDouble() {
        return (double) nominator / denominator;
    }

    // Optional: Getter für Zähler und Nenner
    public int getNominator() {
        return nominator;
    }

    public int getDenominator() {
        return denominator;
    }
}
