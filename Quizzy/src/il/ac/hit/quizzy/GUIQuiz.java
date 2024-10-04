package il.ac.hit.quizzy;

import javax.swing.*;
import java.util.List;

public class GUIQuiz implements IQuiz {
    private String name;

    @Override
    public void start() {
        // GUI implementation
        JOptionPane.showMessageDialog(null, "Starting GUI Quiz: " + name);
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
        // Add GUI questions handling logic
    }

    @Override
    public List<IQuizQuestion> getQuestions() {
        return List.of();
    }
}
