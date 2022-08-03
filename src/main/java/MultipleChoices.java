import java.util.ArrayList;
public class MultipleChoices extends Answer{
    private ArrayList<String> IncorrectAnswers;
    public MultipleChoices(String correctAnswers, ArrayList<String> incorrectAnswers){
        this.correctAnswer = correctAnswers;
        this.IncorrectAnswers = incorrectAnswers;
    }
    public ArrayList<String> getIncorrectAnswers(){
        return IncorrectAnswers;
    }
}
