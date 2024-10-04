package il.ac.hit.quizzy;

public interface IQuizFilesDAO {
    void saveQuizToFile(IQuiz quiz, String fileName) throws QuizException;
    IQuiz loadQuizFromFile(String fileName) throws QuizException;

    class QuizException extends Exception {
        public QuizException(String errorSavingQuizToFile) {
        }
    }
}
