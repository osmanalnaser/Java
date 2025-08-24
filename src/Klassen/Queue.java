package Klassen;

public interface Queue {
    final int EMPTY_VALUE = -1;


    void append(int value);


    boolean isEmpty();


    void remove();


    int peek();


    int[] toArray();
}
