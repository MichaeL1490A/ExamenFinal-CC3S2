import java.util.ArrayList;
public class MultipleChoices implements Answer{
    private String CorrectAnswer;
    private ArrayList<String> IncorrectAnswers;
    public MultipleChoices(String correctAnswers, ArrayList<String> incorrectAnswers){
        this.CorrectAnswer = correctAnswers;
        this.IncorrectAnswers = incorrectAnswers;
    }
    @Override
    public void setAnswer(String answer){
        this.CorrectAnswer = answer;
    }
    @Override
    public String getAnswer(){
        return CorrectAnswer;
    }
}
