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
    private ArrayList<String> answers;
    public MultipleChoices(String correctAnswers, ArrayList<String> incorrectAnswers){
        this.correctAnswer = correctAnswers;
        this.incorrectAnswers = incorrectAnswers;
    }
    public MultipleChoices(){}
    public ArrayList<String> getIncorrectAnswers(){
        return incorrectAnswers;
    }
    public void setIncorrectAnswers(ArrayList<String> incorrectAnswers){
        this.incorrectAnswers = incorrectAnswers;
    }
    public String toString(){
        answers = new ArrayList<>();
        this.answers.add(this.correctAnswer);
        this.answers.addAll(this.incorrectAnswers);
        StringBuilder info = new StringBuilder();
        for (String s : this.answers){
            info.append(s).append("\n");
        }
        return info.toString();
    }
}

class Word extends Answer{
    public Word(String answer){
        this.correctAnswer = answer;
    }
    public Word(){}
    public String toString(){
        return correctAnswer;
    }
}

