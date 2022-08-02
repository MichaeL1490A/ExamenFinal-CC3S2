import java.util.Scanner;

public class OpenQuestion implements Question {
    public String Question;
    public String Answers;

    public OpenQuestion(String Question, String CorrectAnswer){
        this.Question = Question;
        this.Answers = CorrectAnswer;
    }
    @Override
    public void Ask(){
        Scanner input = new Scanner(System.in);
        System.out.println(Question);
        String Answer = input.nextLine();
        if(Answer == Answers){
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