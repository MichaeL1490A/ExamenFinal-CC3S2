import java.util.ArrayList;

public abstract class Answer {
    String correctAnswer;
    Answer() {}
    String getCorrectAnswer(){
        return correctAnswer;
    }
    void setCorrectAnswer(String s){
        correctAnswer = s;
    }
}

class MultipleChoices extends Answer{
    private ArrayList<String> incorrectAnswers;
    public MultipleChoices(String correctAnswers, ArrayList<String> incorrectAnswers){
        this.correctAnswer = correctAnswers;
        this.incorrectAnswers = incorrectAnswers;
    }
    public ArrayList<String> getIncorrectAnswers(){
        return incorrectAnswers;
    }
}

class Word extends Answer{
    public Word(String answer){
        this.correctAnswer = answer;
    }
}

