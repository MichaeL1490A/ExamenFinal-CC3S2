import java.util.Objects;

interface IFlashcard{
    void setQuestion(Question q);
    void setAnswer(Answer a);
}
class WordFlashcard implements IFlashcard{
    private Question question;
    private Answer answer;
    @Override
    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
class mcFlashcard implements IFlashcard{

    private Question question;
    private Answer answer;
    @Override
    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}

class Director{
    public void constructMCFlashcard(IFlashcard iflashcard){

    }
}
public class Flashcard {
    private Question question;
    private Answer answer;
    public Flashcard(Question question, Answer answer){
        this.question = question;
        this.answer = answer;
    }
    public Answer getAnswer() {
        return answer;
    }
    public Question getQuestion() {
        return question;
    }
    public boolean isCorrect(String answer){
        return Objects.equals(answer, this.answer.getCorrectAnswer());
    }
}

