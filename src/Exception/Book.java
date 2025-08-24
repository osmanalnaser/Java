package Exception;

public class Book {
    private String title;
    private String ISBN;


    public Book(String title, String ISBN) throws IllegalArgumentException, IllegalISBNException {
        if (title == null || ISBN == null) {
            throw new IllegalArgumentException("Titel und ISBN dürfen nicht null sein.");
        }
        this.title = title;
        validateISBN(ISBN); // ISBN validieren
        this.ISBN = ISBN;
    }


    public String getTitle() {
        return title;
    }

    public String getISBN() {
        return ISBN;
    }


    private void validateISBN(String isbn) throws IllegalISBNException {
        if (isbn.length() == 10) {
            // Prüfe, ob die ersten 9 Zeichen Zahlen sind
            for (int i = 0; i < 9; i++) {
                if (!Character.isDigit(isbn.charAt(i))) {
                    throw new IllegalISBN10Exception("ISBN enthaelt ein ungueltiges Zeichen");
                }
            }
            // Prüfe das 10. Zeichen
            char lastChar = isbn.charAt(9);
            if (!Character.isDigit(lastChar) && lastChar != 'X' && lastChar != 'x') {
                throw new IllegalISBN10Exception("ISBN enthaelt ein ungueltiges Zeichen");
            }
        } else if (isbn.length() == 13) {
            // Prüfe, ob die ISBN mit "978" beginnt
            if (!isbn.startsWith("978")) {
                throw new IllegalISBN13Exception("ISBN der Laenge 13 faengt nicht mit 978 an");
            }
            // Prüfe, ob alle Zeichen Zahlen sind
            for (int i = 0; i < 13; i++) {
                if (!Character.isDigit(isbn.charAt(i))) {
                    throw new IllegalISBN13Exception("ISBN enthaelt ein ungueltiges Zeichen");
                }
            }
        } else {
            // Ungültige Länge
            throw new IllegalISBNException("Laenge stimmt nicht für eine gueltige ISBN");
        }
    }


    public static void main(String[] args) {
        try {
            Book b1 = new Book("Mein Buch", "123456789X");
            System.out.println("Titel: " + b1.getTitle() + ", ISBN: " + b1.getISBN());

            Book b2 = new Book("Anderes Buch", "9780123456789");
            System.out.println("Titel: " + b2.getTitle() + ", ISBN: " + b2.getISBN());

            // Ungültige ISBN
            Book b3 = new Book("Fehlerbuch", "123456789x3");
        } catch (IllegalArgumentException | IllegalISBNException e) {
            System.err.println("Fehler: " + e.getMessage());
        }
    }
}