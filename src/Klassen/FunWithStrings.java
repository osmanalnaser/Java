package Klassen;

public class FunWithStrings {


    public static int countWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0;
        }

        String[] words = text.trim().split("\\s+");
        return words.length;
    }


    public static String getQuotedText(String text) {
        if (text == null) return null;

        int firstQuote = text.indexOf('"');
        int secondQuote = text.lastIndexOf('"');


        if (firstQuote == -1 || secondQuote == -1 || firstQuote == secondQuote) {
            return null;
        }

        return text.substring(firstQuote + 1, secondQuote);
    }

    //  3. längster gemeinsamer Prefix
    public static String commonPrefix(String text1, String text2) {
        if (text1 == null || text2 == null) {
            return "";
        }

        int minLength = Math.min(text1.length(), text2.length());
        int i = 0;

        while (i < minLength && text1.charAt(i) == text2.charAt(i)) {
            i++;
        }

        return text1.substring(0, i);
    }


    public static void main(String[] args) {
        System.out.println("countWords:");
        System.out.println(countWords("Dies ist ein Test")); // 4
        System.out.println(countWords("   Viele   Leerzeichen   ")); // 2

        System.out.println("\ngetQuotedText:");
        System.out.println(getQuotedText("keine Anführungszeichen")); // null
        System.out.println(getQuotedText("nur ein \"Anführungszeichen")); // null
        System.out.println(getQuotedText("vorher \"Text\" nachher")); // "Text"
        System.out.println(getQuotedText("vorher \"\" nachher")); // ""

        System.out.println("\ncommonPrefix:");
        System.out.println(commonPrefix("First", "Second")); // ""
        System.out.println(commonPrefix("xyzTest", "xyzHello")); // "xyz"
        System.out.println(commonPrefix("Hello", "Hello")); // "Hello"
    }
}
