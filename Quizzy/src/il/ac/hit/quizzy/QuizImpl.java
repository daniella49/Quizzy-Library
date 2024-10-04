package il.ac.hit.quizzy;

import java.util.ArrayList;
import java.util.List;

public class QuizImpl implements IQuiz {
    private String name;
    private final List<IQuizQuestion> questions;

    public QuizImpl(String name) {
        this.name = name;
        this.questions = new ArrayList<>();
    }

    @Override
    public void start() {
        // Implement the quiz starting logic (e.g., displaying questions to the user)
        // Note: For simplicity, this example does not implement this method.
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
        questions.add(question);
    }

    public List<IQuizQuestion> getQuestions() {
        return questions; // Add a method to retrieve the list of questions
    }
}
