package arrays;

public class IsSortedArray {

    public static void main(String[] args) {
        int[] sorted = {1, 2, 3, 4, 5};
        int[] unsorted = {3, 1, 4, 2};
        int[] empty = {};

        System.out.println(isSorted(sorted));
        System.out.println(isSorted(unsorted));
        System.out.println(isSorted(empty));
        System.out.println(isSorted(null));
    }

    public static boolean isSorted(int[] a) {
        if (a == null) {
            return false; // null gilt nicht als sortiert
        }

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }
        return true;
    }
}

