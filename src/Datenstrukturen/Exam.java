package Datenstrukturen;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Exam {
    private String name;
    private int year;
    private List<Question> questions;

    public Exam(String name, int year) {
        this.name = name;
        this.year = year;
        this.questions = new ArrayList<>();
    }

    public void addQuestion(Question q) {
        if (q != null) {
            questions.add(q);
        }
    }

    public List<Question> getQuestions() {
        return new ArrayList<>(questions);
    }

    public int getNumberOfQuestions() {
        return questions.size();
    }

    public int getSumOfPoints() {
        return questions.stream().mapToInt(Question::getPoints).sum();
    }


    public void orderQuestionsByLength() {
        questions.sort((q1, q2) -> Integer.compare(q2.getText().length(), q1.getText().length()));
    }

    // Absteigend nach Punkte
    public void orderQuestionsByPoints() {
        questions.sort((q1, q2) -> Integer.compare(q2.getPoints(), q1.getPoints()));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(" (").append(year).append(")\n");
        for (Question q : questions) {
            sb.append(q).append("\n");
        }
        return sb.toString();
    }
}
