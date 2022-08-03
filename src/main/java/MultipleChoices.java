import java.util.ArrayList;

public class MultipleChoices implements Answer{
    private String[] CorrectAnswers;
    private String[] IncorrectAnswers;
    @Override
    private void setAnswer(String[] correctAnswers, String[] incorrectAnswers){
        this.CorrectAnswers = correctAnswers;
        this.IncorrectAnswers = incorrectAnswers;
    }
    @Override
    public String getAnswer(){

    }
    @Override
    public String toString(){

    }
}
