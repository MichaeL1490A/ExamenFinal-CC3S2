import java.util.Objects;

interface IFlashcard{
    void setQuestion(Question q);
    void setAnswer(Answer a);
}
class WordFlashcardBuilder implements IFlashcard {
    private Question question;
    private Answer answer;

    @Override
    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public boolean isCorrect() {
        return false;
    }

    @Override
    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
    public Flashcard getResult(){
        return new Flashcard(question,answer);
    }
}
class mcFlashcardBuilder implements IFlashcard{

    private Question question;
    private Answer answer;
    @Override
    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public boolean isCorrect() {
        return false;
    }
    @Override
    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
    public Flashcard getResult(){
        return new Flashcard(question,answer);
    }
}

class Flashcard {
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
class Director{
    public void constructMCFlashcard(IFlashcard iflashcard){
        iflashcard.setQuestion(new Question());
        iflashcard.setAnswer(new MultipleChoices());
    }
    public void constructWordlashcard(IFlashcard iflashcard){
        iflashcard.setQuestion(new Question());
        iflashcard.setAnswer(new Word());
    }
}

public class main{
    public static void main(String[] args){
        Director director = new Director();

        mcFlashcard mcflashcard = new mcFlashcard();
        director.constructMCFlashcard(mcflashcard);

        WordFlashcard wordFlashcard = new WordFlashcard();
        director.constructWordlashcard(wordFlashcard);
        Answer answer = new Word("2");
        Question question = new Question("Cuanto es 1+1");
        wordFlashcard.setAnswer(answer);
        wordFlashcard.setQuestion(question);
    }
}
