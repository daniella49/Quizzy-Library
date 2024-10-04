package il.ac.hit.quizzy.tests;

import static org.junit.jupiter.api.Assertions.*;

import il.ac.hit.quizzy.IQuiz;
import il.ac.hit.quizzy.IQuizQuestion;
import il.ac.hit.quizzy.QuizImpl;
import il.ac.hit.quizzy.QuizQuestion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class QuizTest {

    private IQuiz quiz;

    @BeforeEach
    public void setUp() {
        quiz = new QuizImpl("General Knowledge Quiz");
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
        assertEquals(1, quiz.getQuestions().size());
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
        List<IQuizQuestion> questions = quiz.getQuestions();
        assertEquals(1, questions.size());
        assertEquals("What is the capital of France?", questions.get(0).getQuestion());
    }

    @Test
    public void testStart() {
        // Assuming start doesn't throw an exception for now
        assertDoesNotThrow(() -> quiz.start());
    }
}
