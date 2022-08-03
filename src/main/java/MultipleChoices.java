import java.util.ArrayList;
public class MultipleChoices extends Answer{
    private ArrayList<String> incorrectAnswers;
    public MultipleChoices(String correctAnswers, ArrayList<String> incorrectAnswers){
        this.correctAnswer = correctAnswers;
        this.incorrectAnswers = incorrectAnswers;
    }
    public ArrayList<String> getIncorrectAnswers(){
        return incorrectAnswers;
    }
}
