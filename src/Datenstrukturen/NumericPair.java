package Datenstrukturen;

public class NumericPair<T extends Number> extends IdenticalPair<T> {

    public NumericPair(T first, T second) {
        super(first, second);
    }

    // Methode zur Berechnung der Summe
    public double sum() {
        return getFirst().doubleValue() + getSecond().doubleValue();
    }
}
