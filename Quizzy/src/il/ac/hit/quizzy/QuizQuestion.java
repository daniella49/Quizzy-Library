package il.ac.hit.quizzy;

public class QuizQuestion implements IQuizQuestion {
    private String question;
    private String[] answers;
    private int correctAnswerIndex;

    protected QuizQuestion(String question, String[] answers, int correctAnswerIndex) {
        this.question = question;
        this.answers = answers;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    @Override
    public String getQuestion() {
        return question;
    }

    @Override
    public String[] getAnswers() {
        return answers;
    }

    @Override
    public boolean isCorrect(int answerIndex) {
        return answerIndex == correctAnswerIndex;
    }

    // Nested Builder class
    public static class Builder implements IQuizQuestionBuilder {
        private String question;
        private String[] answers = new String[5];  // Assuming max 5 answers
        private int correctAnswerIndex = -1;
        private int answerCount = 0;

        @Override
        public IQuizQuestionBuilder setTitle(String text) {
            this.question = text;
            return this;
        }

        @Override
        public IQuizQuestionBuilder setQuestion(String question) {
            this.question = question;  // Ensure this matches the interface
            return this;
        }

        @Override
        public IQuizQuestionBuilder addAnswer(String text, boolean correct) {
            if (answerCount < 5) {
                answers[answerCount] = text;
                if (correct) {
                    correctAnswerIndex = answerCount;
                }
                answerCount++;
            }
            return this;
        }

        @Override
        public IQuizQuestion create() {
            return new QuizQuestion(question, answers, correctAnswerIndex);
        }
    }
}
