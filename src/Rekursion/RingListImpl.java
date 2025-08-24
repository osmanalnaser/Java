package Rekursion;

public class RingListImpl implements RingList {

    private static class Element {
        int value;
        Element next;

        Element(int value) {
            this.value = value;
        }
    }

    private Element current;

    public RingListImpl() {
        current = null;
    }

    @Override
    public void add(int value) {
        Element newElem = new Element(value);
        if (current == null) {
            newElem.next = newElem;
            current = newElem;
        } else {

            Element tail = current;
            while (tail.next != current) {
                tail = tail.next;
            }
            newElem.next = current;
            tail.next = newElem;
            current = newElem;
        }
    }

    @Override
    public int getCurrentValue() {
        if (current == null) {
            throw new IllegalStateException("Liste ist leer");
        }
        return current.value;
    }

    @Override
    public void rotate() {
        if (current != null) {
            current = current.next;
        }
    }

    @Override
    public void removeCurrent() {
        if (current == null) {
            throw new IllegalStateException("Liste ist leer");
        }

        if (current.next == current) {

            current = null;
        } else {

            Element tail = current;
            while (tail.next != current) {
                tail = tail.next;
            }
            tail.next = current.next;
            current = current.next;
        }
    }

    @Override
    public boolean contains(int value) {
        if (current == null) return false;

        Element temp = current;
        do {
            if (temp.value == value) return true;
            temp = temp.next;
        } while (temp != current);

        return false;
    }

    @Override
    public String toString() {
        if (current == null) return "[]";

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Element temp = current;
        do {
            sb.append(temp.value);
            temp = temp.next;
            if (temp != current) sb.append(", ");
        } while (temp != current);
        sb.append("]");
        return sb.toString();
    }


    public static void main(String[] args) {
        RingListImpl ring = new RingListImpl();
        ring.add(12);
        ring.add(99);
        ring.add(37);
        System.out.println(ring); // [37, 99, 12]

        ring.rotate();
        System.out.println(ring.getCurrentValue()); // 99

        ring.removeCurrent();
        System.out.println(ring); // [12, 37]
        System.out.println(ring.contains(37)); // true
        System.out.println(ring.contains(99)); // false
    }
}
