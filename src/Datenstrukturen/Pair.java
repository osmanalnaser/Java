package Datenstrukturen;

public class Pair<T, U> {
    // private Instanzvariablen
    private T first;
    private U second;


    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }


    public T getFirst() {
        return first;
    }

    public U getSecond() {
        return second;
    }


    public void setFirst(T first) {
        if (first != null) {
            this.first = first;
        }
    }

    public void setSecond(U second) {
        if (second != null) {
            this.second = second;
        }
    }
}
