import java.util.Objects;
import java.util.Scanner;

public class CloseQuestion implements Question {
    public String Question;
    public String[] Answers;
    public CloseQuestion(String Question, String[] CorrectAnswer){
        this.Question = Question;
        this.Answers = CorrectAnswer;
    }
    @Override
    public void Ask(){
        Scanner input = new Scanner(System.in);
        System.out.println(Question);
        String Answer = input.nextLine();
        if(Objects.equals(Answer, Answers[0])){
            System.out.println("Correcto");
        }
        else{
            System.out.println("Incorrecto");
        }
    }
}
/*
class Main {
    public static void main(String[] args) {
        String[] answer = {"1","2","3","4"};
        CloseQuestion a = new CloseQuestion("Cual es tu color favorito",answer);
        a.Ask();
    }
}
 */