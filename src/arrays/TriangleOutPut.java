package arrays;
import java.util.Scanner;

    public class TriangleOutPut {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            System.out.print("Bitte geben Sie die Größe des Dreiecks ein: ");
            int size = sc.nextInt();

            // geschachtelte Schleifen zur Ausgabe des Dreiecks
            for (int i = 1; i <= size; i++) {        // äußere Schleife = Zeilen
                for (int j = 1; j <= i; j++) {       // innere Schleife = Sterne pro Zeile
                    System.out.print("*");
                }
                System.out.println();                // Zeilenumbruch nach jeder Reihe
            }

            sc.close();
        }
    }


