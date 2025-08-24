package Rekursion;

public interface RingList {
    void add(int value);
    int getCurrentValue();
    void rotate();
    void removeCurrent();
    boolean contains(int value);
}

