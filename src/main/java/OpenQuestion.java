import java.util.Scanner;

public class OpenQuestion implements Question {
    public String Question;
    public String CorrectAnswer;
    public Scanner input = new Scanner(System.in);
    public OpenQuestion(String Question, String CorrectAnswer){
        this.Question = Question;
        this.CorrectAnswer = CorrectAnswer;
    }
    @Override
    public void Ask(){
        System.out.println(Question);
        String Answer = input.nextLine();
        if(Answer == CorrectAnswer){
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
        OpenQuestion a = new OpenQuestion("Cual es tu color favorito", "Rojo");
        a.Ask();
    }
}

 */