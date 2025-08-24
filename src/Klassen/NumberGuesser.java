package Klassen;

import java.util.Scanner;

public class NumberGuesser {


    private static boolean askYesNo(Scanner sc, String question) {
        while (true) {
            System.out.println(question);
            String s = sc.nextLine().trim().toLowerCase();
            if (s.equals("ja"))   return true;
            if (s.equals("nein")) return false;

        }
    }


    public static void guess(int maxNumber) {
        Scanner sc = new Scanner(System.in);

        int low = 0;
        int high = maxNumber;

        while (low < high) {
            int mid = (low + high) / 2;
            boolean greater = askYesNo(sc, "Ist die gedachte Zahl groesser als " + mid + "?");
            if (greater) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        System.out.println("Die gedachte Zahl ist: " + low);

    }
}
