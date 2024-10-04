package il.ac.hit.quizzy;

public interface IQuizQuestion {
    public String getQuestion();
    public String[] getAnswers();
    public boolean isCorrect(int answerIndex);
}
