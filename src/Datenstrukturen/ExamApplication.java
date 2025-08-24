package Datenstrukturen;

public class ExamApplication {
    public static void main(String[] args) {

        Exam exam = new Exam("Java Grundlagen", 2025);


        exam.addQuestion(new Question("Was ist Java?", 5));
        exam.addQuestion(new Question("Erklären Sie den Unterschied zwischen Array und ArrayList.", 10));

        // Ausgabe vor Sortierung
        System.out.println("Prüfung vor Sortierung:");
        System.out.println(exam);

        // Absteigend nach Länge sortieren
        exam.orderQuestionsByLength();
        System.out.println("Nach Länge absteigend sortiert:");
        System.out.println(exam);

        // Absteigend nach Punkten sortieren
        exam.orderQuestionsByPoints();
        System.out.println("Nach Punkte absteigend sortiert:");
        System.out.println(exam);
    }
}
