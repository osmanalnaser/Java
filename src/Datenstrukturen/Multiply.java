package Datenstrukturen;

public class Multiply implements GenericFunction<Integer, Integer> {
    private int factor;


    public Multiply(int factor) {
        this.factor = factor;
    }

    @Override
    public Integer calculate(Integer x) {
        return x * factor;
    }
}
