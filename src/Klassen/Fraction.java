package Klassen;

public class Fraction {
    private int nominator;
    private int denominator;


    public Fraction(int nominator, int denominator) {
        this.nominator = nominator;
        if (denominator == 0) {
            this.denominator = 1; // Nenner darf nicht 0 sein
        } else {
            this.denominator = denominator;
        }
    }


    public Fraction(int n) {
        this.nominator = n;
        this.denominator = 1;
    }


    public void multiply(Fraction factor) {
        this.nominator = this.nominator * factor.nominator;
        this.denominator = this.denominator * factor.denominator;
    }


    public void add(Fraction summand) {
        this.nominator = this.nominator * summand.denominator
                + summand.nominator * this.denominator;
        this.denominator = this.denominator * summand.denominator;
    }


    @Override
    public String toString() {
        return nominator + "/" + denominator;
    }


    public double asDouble() {
        return (double) nominator / denominator;
    }


    public int getNominator() {
        return nominator;
    }

    public int getDenominator() {
        return denominator;
    }
}
