package il.ac.hit.quizzy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TerminalQuiz implements IQuiz {
    private String name;
    private List<IQuizQuestion> questions = new ArrayList<>();
    private int correctAnswers = 0;

    @Override
    public void start() {
        Scanner scanner = new Scanner(System.in);
        for (IQuizQuestion question : questions) {
            System.out.println(question.getQuestion());
            String[] answers = question.getAnswers();
            for (int i = 0; i < answers.length; i++) {
                System.out.println((i + 1) + ". " + answers[i]);
            }
            int userAnswer = scanner.nextInt() - 1;
            if (question.isCorrect(userAnswer)) {
                correctAnswers++;
            }
        }
        System.out.println("Quiz over! You got " + correctAnswers + " out of " + questions.size() + " correct.");
    }

    @Override
    public void setName(String text) {
        this.name = text;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void addQuestion(IQuizQuestion question) {
        this.questions.add(question);
    }

    @Override
    public List<IQuizQuestion> getQuestions() {
        return List.of();
    }
}
