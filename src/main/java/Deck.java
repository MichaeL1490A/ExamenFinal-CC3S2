import java.util.List;

public class Deck {
    public String name;
    public List<Question> Deck;

    public void showQuestions(){
        for(Question question : Deck){
            question.show();
        }
    }
    public void addQuestion(Question q){
        Deck.add(q);
    }
    public void deleteQuestion(Question q){
        Deck.remove(q);
    }
    /*
    public List<Question> createDeck(){
        List<Question> Questions = new ArrayList<Question>();

        Question Pregunta1 = new OpenQuestion("hola","adios");
        Questions.add(Pregunta1);

        return Questions;
    }
     */
}
