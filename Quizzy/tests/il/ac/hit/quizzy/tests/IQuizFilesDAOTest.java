package il.ac.hit.quizzy.tests;

import static org.junit.jupiter.api.Assertions.*;
import il.ac.hit.quizzy.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

public class IQuizFilesDAOTest {

    private IQuizFilesDAO dao;
    private String testFileName = "testQuiz.csv";
    private IQuiz quiz;

    @BeforeEach
    public void setUp() {
        dao = SimpleCSVQuizFilesDAO.getInstance();
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
    public void testSaveQuizToFile() throws IQuizFilesDAO.QuizException {
        dao.saveQuizToFile(quiz, testFileName);
        File file = new File(testFileName);
        assertTrue(file.exists());
    }

    @Test
    public void testLoadQuizFromFile() throws IQuizFilesDAO.QuizException {
        dao.saveQuizToFile(quiz, testFileName);
        IQuiz loadedQuiz = dao.loadQuizFromFile(testFileName);
        assertEquals("General Knowledge Quiz", loadedQuiz.getName());
        assertEquals(1, loadedQuiz.getQuestions().size());
    }

    @AfterEach
    public void tearDown() {
        File file = new File(testFileName);
        if (file.exists()) {
            file.delete();
        }
    }
}
