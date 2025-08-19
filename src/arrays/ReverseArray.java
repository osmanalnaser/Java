package arrays;

public class ReverseArray {

    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4, 5};
        int[] reversed = reverse(original);

        // Ausgabe zum Testen
        System.out.print("Original: ");
        printArray(original);
        System.out.print("Umgekehrt: ");
        printArray(reversed);
    }

    public static int[] reverse(int[] a) {
        int[] result = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            result[i] = a[a.length - 1 - i];
        }
        return result;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
