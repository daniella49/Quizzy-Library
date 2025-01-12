package il.ac.hit.quizzy;

public class QuizFactory {
    public IQuiz createQuiz(QuizType type) {
        if (type == null) {
            throw new IllegalArgumentException("Invalid quiz type");
        }

        switch (type) {
            case TERMINAL:
                return new TerminalQuiz();
            case GUI:
                return new GUIQuiz();
            default:
                throw new IllegalArgumentException("Invalid quiz type");
        }
    }
}


//TerminalQuiz: Runs the quiz in the terminal, allowing users to input their answers.
//GUIQuiz: Runs the quiz in a simple GUI using JOptionPane.
//QuizFactory: Creates either a GUIQuiz or TerminalQuiz based on the QuizType.
