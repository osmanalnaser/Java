package Klassen;

public class LinkedQueue implements Queue {

    // innerer Knoten der Liste
    private static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node head; // erstes Element
    private Node tail; // letztes Element


    public LinkedQueue() {
        this.head = null;
        this.tail = null;
    }

    @Override
    public void append(int value) {
        Node newNode = new Node(value);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public void remove() {
        if (!isEmpty()) {
            head = head.next;
            if (head == null) { // falls letzte Node entfernt wurde
                tail = null;
            }
        }
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            return EMPTY_VALUE;
        }
        return head.value;
    }

    @Override
    public int[] toArray() {
        // Länge bestimmen
        int size = 0;
        Node current = head;
        while (current != null) {
            size++;
            current = current.next;
        }

        // Array füllen
        int[] result = new int[size];
        current = head;
        int i = 0;
        while (current != null) {
            result[i++] = current.value;
            current = current.next;
        }

        return result;
    }
}
