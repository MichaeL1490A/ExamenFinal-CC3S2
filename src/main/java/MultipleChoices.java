import java.util.ArrayList;

public class MultipleChoices implements Answer{
    private String CorrectAnswer;
    private ArrayList<String> IncorrectAnswers;
    private ArrayList<String> Answers;
    public MultipleChoices(String correctAnswers, ArrayList<String> incorrectAnswers){
        this.CorrectAnswer = correctAnswers;
        this.IncorrectAnswers = incorrectAnswers;
    }
    @Override
    public void setAnswer(){
        this.Answers = new ArrayList<>();
    }
    @Override
    public String getAnswer(){
        return this.CorrectAnswer;
    }
}
