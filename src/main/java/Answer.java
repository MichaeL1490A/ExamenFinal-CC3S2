import java.util.ArrayList;

public abstract class Answer {
    private String correctAnswer;
    Answer() {}
    String getCorrectAnswer(){
        return correctAnswer;
    }
    void setCorrectAnswer(String correctAnswer) {this.correctAnswer = correctAnswer;}
}

class MultipleChoices extends Answer{
    private ArrayList<String> incorrectAnswers;

    public MultipleChoices(String correctAnswers, ArrayList<String> incorrectAnswers){
        setCorrectAnswer(correctAnswers);
        this.incorrectAnswers = incorrectAnswers;
    }
    public MultipleChoices(){}
    public String toString(){
        ArrayList<String> answers = new ArrayList<>();
        answers.add(getCorrectAnswer());
        answers.addAll(this.incorrectAnswers);
        StringBuilder info = new StringBuilder();
        for (String s : answers){
            info.append(s).append("\n");
        }
        return info.toString();
    }
}

class Word extends Answer{
    public Word(String answer){
        setCorrectAnswer(answer);
    }
    public Word(){}
    public String toString(){
        return getCorrectAnswer();
    }
}

