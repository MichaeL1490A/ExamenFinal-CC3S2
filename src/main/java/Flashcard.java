import java.util.Objects;

public class Flashcard {
    private Question question;
    private Answer answer;
    public Flashcard(Question question, Answer answer){
        this.question = question;
        this.answer = answer;
    }
    public boolean isCorrect(String answer){
        return Objects.equals(answer, this.answer.getCorrectAnswer());
    }
}
