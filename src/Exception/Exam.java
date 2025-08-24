package Exception;

import java.io.*;
import java.util.ArrayList;

public class Exam {
    private String title;
    private int year;
    private ArrayList<Question> questions;

    public Exam(String title, int year) {
        this.title = title;
        this.year = year;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question q) {
        questions.add(q);
    }

    // Methode zum Speichern
    public void save() {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("config.txt")))) {
            writer.println(title);
            writer.println(year);
            writer.println(questions.size());
            for (Question q : questions) {
                writer.println(q.getText());
                writer.println(q.getPoints());
            }
            System.out.println("Prüfung erfolgreich gespeichert.");
        } catch (IOException e) {
            System.err.println("Fehler beim Speichern: " + e.getMessage());
        }
    }

    // Methode zum Laden
    public boolean load() {
        try (BufferedReader reader = new BufferedReader(new FileReader("config.txt"))) {
            // Alte Fragen löschen
            questions.clear();

            // Prüfungstitel und Jahr einlesen
            title = reader.readLine();
            String yearLine = reader.readLine();
            year = Integer.parseInt(yearLine);

            // Anzahl der Fragen einlesen
            int numQuestions = Integer.parseInt(reader.readLine());

            // Fragen einlesen
            for (int i = 0; i < numQuestions; i++) {
                String text = reader.readLine();
                int points = Integer.parseInt(reader.readLine());
                questions.add(new Question(text, points));
            }

            return true;
        } catch (IOException | NumberFormatException e) {
            System.err.println("Fehler beim Laden: " + e.getMessage());
            return false;
        }
    }


    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    // Test
    public static void main(String[] args) {
        Exam exam = new Exam("Mathematik", 2025);
        exam.addQuestion(new Question("Was ist 2+2?", 5));
        exam.addQuestion(new Question("Integrieren Sie x^2.", 10));

        exam.save();

        Exam loadedExam = new Exam("", 0);
        if (loadedExam.load()) {
            System.out.println("Titel: " + loadedExam.getTitle());
            System.out.println("Jahr: " + loadedExam.getYear());
            for (Question q : loadedExam.getQuestions()) {
                System.out.println(q.getText() + " (" + q.getPoints() + " Punkte)");
            }
        }
    }
}