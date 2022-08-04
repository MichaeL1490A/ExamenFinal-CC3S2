import java.util.*;

interface Quizzes {
    List<Deck> randomize();
    void addDeck(Deck d);
    void deleteDeck(Deck d);
    List<Deck> getDeck();
}
class Quiz implements Quizzes{
    private List<Deck> decks = new ArrayList<>();
    public Quiz(){}
    @Override
    public void addDeck(Deck d){
        decks.add(d);
    }
    @Override
    public void deleteDeck(Deck d){
        decks.remove(d);
    }

    @Override
    public List<Deck> getDeck() {
        return decks;
    }

    @Override
    public List<Deck> randomize(){
        return decks;
    }
}

abstract class QuizDecorator implements Quizzes{
    protected Quizzes decoratedquiz;
    public QuizDecorator(Quizzes quiz){
        this.decoratedquiz = quiz;
    }
    @Override
    public void addDeck(Deck d){
        decoratedquiz.addDeck(d);
    }
    @Override
    public void deleteDeck(Deck d){
        decoratedquiz.deleteDeck(d);
    }
    @Override
    public List<Deck> randomize(){
        return decoratedquiz.randomize();
    }
    @Override
    public List<Deck> getDeck(){
        return decoratedquiz.getDeck();
    }
}

class TimeQuiz extends QuizDecorator{
    private List<Deck> decks = new ArrayList<>();
    private Date time;
    public TimeQuiz(Quizzes quiz){
        super(quiz);
        this.decks = decoratedquiz.getDeck();
    }
    /*
    New action
    @Override
    public String action(){
        return decoratedquiz.action() + setTime(decoratedquiz);
    }
    */
    private String setTime(Quizzes timeQuiz){
        return "Tiempo añadido";
    }
}
/*
public class DecoratorPatternTest{
    public  static void main(String[] args){
        Quizzes quizz = new Quiz();
        quizz.setPrueba("Pruebita");
        System.out.println(quizz.getPrueba());
        System.out.println(quizz.action());
        quizz = new TimeQuiz(quizz);
        System.out.println(quizz.action());
        System.out.println(quizz.getPrueba());
    }
}
*/