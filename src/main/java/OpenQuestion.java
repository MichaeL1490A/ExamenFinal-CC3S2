import java.util.Scanner;

public class OpenQuestion implements Question {
    public String Question;
    public String Answer;

    public OpenQuestion(String Question, String CorrectAnswer){
        this.Question = Question;
        this.Answer = CorrectAnswer;
    }
    public OpenQuestion(){}
    public void setQuestion(String question) {
        Question = question;
    }
    public void setAnswers(String answer){
        Answer = answer;
    }

    @Override
    public void ask(){
        Scanner input = new Scanner(System.in);
        System.out.println(Question);
        String ans = input.nextLine();
        if(Answer.equals(ans)){
            System.out.println("Correcto");
        }
        else{
            System.out.println("Incorrecto");
        }
    }
    @Override
    public void show(){
        System.out.println(Question);
        System.out.println(Answer);
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