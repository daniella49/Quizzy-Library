package il.ac.hit.quizzy;

import java.util.List;

public interface IQuiz {
    public abstract void start(); // Start the quiz
    public abstract void setName(String text); // Set the quiz name
    public abstract String getName(); // Get the quiz name
    public abstract void addQuestion(IQuizQuestion question); // Add a question to the quiz

    List<IQuizQuestion> getQuestions();
}
