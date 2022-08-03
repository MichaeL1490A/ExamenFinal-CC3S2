import java.util.ArrayList;

public class Word implements Answer{
    private String answer;
    public Word(String answer){
        this.answer = answer;
    }
    @Override
    public void setAnswer(String answer){
        this.answer = answer;
    }
    @Override
    public String getAnswer(){
        return answer;
    }
}
