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
    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
    public Flashcard getResult(){
        return new Flashcard(question,answer);
    }
}
class MCFlashcardBuilder implements IFlashcard{

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
    public Flashcard getResult(){
        return new Flashcard(question,answer);
    }
}

public class Flashcard {
    private final Question question;
    private final Answer answer;
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
    public String toString(){
        String info = "";
        info += "Question: " + question + "\n";
        info += "Answers: " + "\n";
        info += answer + "\n";
        return info;
    }
}
class FlashcardCreator{
    public void constructMCFlashcard(IFlashcard iflashcard){
        iflashcard.setQuestion(new Question());
        iflashcard.setAnswer(new MultipleChoices());
    }
    public void constructWordlashcard(IFlashcard iflashcard){
        iflashcard.setQuestion(new Question());
        iflashcard.setAnswer(new Word());
    }
}
/*
class main{
    public static void main(String[] args){
        Director director = new Director();

        mcFlashcardBuilder mcflashcard = new mcFlashcardBuilder();
        director.constructMCFlashcard(mcflashcard);
        Flashcard flashcard = mcflashcard.getResult();
    }
}
*/