package il.ac.hit.quizzy;

import java.io.*;

public class SimpleCSVQuizFilesDAO implements IQuizFilesDAO {
    private static SimpleCSVQuizFilesDAO instance;

    private SimpleCSVQuizFilesDAO() {
        // Private constructor to enforce Singleton
    }

    public static IQuizFilesDAO getInstance() {
        if (instance == null) {
            instance = new SimpleCSVQuizFilesDAO();
        }
        return instance;
    }

    @Override
    public void saveQuizToFile(IQuiz quiz, String fileName) throws QuizException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Quiz Name: " + quiz.getName() + "\n");
            // Logic to save quiz questions to the file
        } catch (IOException e) {
            throw new QuizException("Error saving quiz to file");
        }
    }

    @Override
    public IQuiz loadQuizFromFile(String fileName) throws QuizException {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // Logic to load quiz from the file
            return null; // Placeholder
        } catch (IOException e) {
            throw new QuizException("Error loading quiz from file");
        }
    }
}

//The SimpleCSVQuizFilesDAO should be able to correctly serialize and deserialize the quiz data to and from a file.
