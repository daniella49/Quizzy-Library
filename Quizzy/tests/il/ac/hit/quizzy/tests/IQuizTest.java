package il.ac.hit.quizzy.tests;

import static org.junit.jupiter.api.Assertions.*;

import il.ac.hit.quizzy.IQuiz;
import il.ac.hit.quizzy.IQuizQuestion;
import il.ac.hit.quizzy.QuizImpl;
import il.ac.hit.quizzy.QuizQuestion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class IQuizTest {

    private IQuiz quiz;

    @BeforeEach
    public void setUp() {
        // Initialize QuizImpl with a name
        quiz = new QuizImpl("General Knowledge Quiz");

        // Add a question to the quiz
        quiz.addQuestion(new QuizQuestion.Builder()
                .setQuestion("What is the capital of France?")
                .addAnswer("Berlin", false)
                .addAnswer("Madrid", false)
                .addAnswer("Paris", true)
                .addAnswer("Lisbon", false)
                .addAnswer("Rome", false)
                .create());
    }

    @Test
    public void testSetName() {
        quiz.setName("New Quiz Name");
        assertEquals("New Quiz Name", quiz.getName());
    }

    @Test
    public void testGetName() {
        assertEquals("General Knowledge Quiz", quiz.getName());
    }

    @Test
    public void testAddQuestion() {
        // Check that the question was added
        assertEquals(1, quiz.getQuestions().size());

        // Add another question and check
        quiz.addQuestion(new QuizQuestion.Builder()
                .setQuestion("What is the capital of Italy?")
                .addAnswer("Berlin", false)
                .addAnswer("Madrid", false)
                .addAnswer("Rome", true)
                .addAnswer("Lisbon", false)
                .addAnswer("Paris", false)
                .create());

        assertEquals(2, quiz.getQuestions().size());
    }

    @Test
    public void testGetQuestions() {
        // Check that the questions are returned correctly
        List<IQuizQuestion> questions = quiz.getQuestions();
        assertEquals(1, questions.size());
        assertEquals("What is the capital of France?", questions.getFirst().getQuestion());
    }
}
