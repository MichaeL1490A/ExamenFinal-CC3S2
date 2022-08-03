

public class TrueFalse implements Answer{
    private String answer;

    public TrueFalse(String answer){
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
