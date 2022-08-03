import java.util.Objects;

interface IFlashcard{
    void setQuestion(Question q);
}
class WordFlashcard implements IFlashcard{
    private Question question;
    private Word answer;
    @Override
    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setAnswer(Word answer) {
        this.answer = answer;
    }
}
class mcFlashcard implements IFlashcard{

    private Question question;
    private MultipleChoices answer;
    @Override
    public void setQuestion(Question question) {
        this.question = question;
    }

    public void setAnswer(MultipleChoices answer) {
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

