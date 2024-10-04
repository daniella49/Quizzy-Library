package il.ac.hit.quizzy;

public interface IQuizQuestionBuilder {
    IQuizQuestionBuilder setTitle(String text); // Correct method
    IQuizQuestionBuilder setQuestion(String question); // Make sure this exists
    IQuizQuestionBuilder addAnswer(String text, boolean correct);
    IQuizQuestion create();
}
