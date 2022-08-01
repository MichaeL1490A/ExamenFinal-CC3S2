import java.util.Objects;
import java.util.Scanner;

public class CloseQuestion {
    public String Question;
    public String[] CorrectAnswer;
    public Scanner input = new Scanner(System.in);
    public CloseQuestion(String Question, String[] CorrectAnswer){
        this.Question = Question;
        this.CorrectAnswer = CorrectAnswer;
    }
    public void Ask(){
        System.out.println(Question);
        String Answer = input.nextLine();
        if(Objects.equals(Answer, CorrectAnswer[0])){
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