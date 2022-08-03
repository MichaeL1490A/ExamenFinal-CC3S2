import java.util.ArrayList;

public class MultipleChoices implements Answer{
    private String CorrectAnswer;
    private ArrayList<String> IncorrectAnswers;
    private String[] Answers;
    public void MultipleChoices(String correctAnswers, ArrayList<String> incorrectAnswers){
        this.CorrectAnswer = correctAnswers;
        this.IncorrectAnswers = incorrectAnswers;
    }
    @Override
    public void setAnswer(){
        this.Answers = new String[1+ this.IncorrectAnswers.length];
        System.arraycopy(this.CorrectAnswer, 0, this.Answers, 0, 1);
        System.arraycopy(this.IncorrectAnswers, 0, this.Answers, 1, this.IncorrectAnswers.length);
    }
    @Override
    public String getAnswer(){

    }
}
