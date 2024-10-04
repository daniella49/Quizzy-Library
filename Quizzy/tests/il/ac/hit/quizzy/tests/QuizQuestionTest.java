package il.ac.hit.quizzy.tests;

import static org.junit.jupiter.api.Assertions.*;
import il.ac.hit.quizzy.QuizQuestion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QuizQuestionTest {

    private QuizQuestion question;

    @BeforeEach
    public void setUp() {
        question = (QuizQuestion) new QuizQuestion.Builder()
                .setQuestion("What is the capital of France?")
                .addAnswer("Berlin", false)
                .addAnswer("Madrid", false)
                .addAnswer("Paris", true)
                .addAnswer("Lisbon", false)
                .addAnswer("Rome", false)
                .create();
    }

    @Test
    public void testGetQuestion() {
        assertEquals("What is the capital of France?", question.getQuestion());
    }

    @Test
    public void testGetAnswers() {
        String[] expectedAnswers = {"Berlin", "Madrid", "Paris", "Lisbon", "Rome"};
        assertArrayEquals(expectedAnswers, question.getAnswers());
    }

    @Test
    public void testIsCorrect() {
        assertTrue(question.isCorrect(2));  // Paris is correct
        assertFalse(question.isCorrect(0)); // Berlin is incorrect
    }
}
