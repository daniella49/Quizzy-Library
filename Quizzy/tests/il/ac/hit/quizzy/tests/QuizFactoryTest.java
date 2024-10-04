package il.ac.hit.quizzy.tests;

import il.ac.hit.quizzy.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuizFactoryTest {

    private QuizFactory factory;

    @BeforeEach
    void setUp() {
        // Initialize the QuizFactory before each test
        factory = new QuizFactory();
    }

    @AfterEach
    void tearDown() {
        // No specific teardown is needed for this test case, but it's good practice
        factory = null;
    }

    @Test
    void createQuiz_TerminalQuiz() {
        // Test the creation of a TerminalQuiz
        IQuiz quiz = factory.createQuiz(QuizType.TERMINAL);
        assertNotNull(quiz, "QuizFactory should return a non-null TerminalQuiz object");
        assertTrue(quiz instanceof TerminalQuiz, "Quiz should be an instance of TerminalQuiz");
    }

    @Test
    void createQuiz_GUIQuiz() {
        // Test the creation of a GUIQuiz
        IQuiz quiz = factory.createQuiz(QuizType.GUI);
        assertNotNull(quiz, "QuizFactory should return a non-null GUIQuiz object");
        assertTrue(quiz instanceof GUIQuiz, "Quiz should be an instance of GUIQuiz");
    }

    @Test
    void createQuiz_InvalidType() {
        // Test that passing null as the quiz type throws an IllegalArgumentException
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            factory.createQuiz(null);
        });
        assertEquals("Invalid quiz type", exception.getMessage());
    }

}
