package arrays;

import java.util.Scanner;

public class ZaehleTEL {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben Sie eine Zeichenfolge ein: ");
        String eingabe = scanner.nextLine();
        char[] zeichen = eingabe.toCharArray();
        countTEL(zeichen);
        scanner.close();
    }

    public static void countTEL(char[] zeichen) {
        int countT = 0;
        int countE = 0;
        int countL = 0;

        for (char c : zeichen) {
            switch (Character.toLowerCase(c)) {
                case 't':
                    countT++;
                    break;
                case 'e':
                    countE++;
                    break;
                case 'l':
                    countL++;
                    break;
            }
        }

        System.out.println("Der Buchstabe \"t\" kommt " + countT + " mal vor.");
        System.out.println("Der Buchstabe \"e\" kommt " + countE + " mal vor.");
        System.out.println("Der Buchstabe \"l\" kommt " + countL + " mal vor.");
    }
}
