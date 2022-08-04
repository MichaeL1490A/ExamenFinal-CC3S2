import java.util.*;
import java.util.concurrent.TimeUnit;
interface Quizzes {
    List<Deck> randomize();
    void addDeck(Deck d);
    void deleteDeck(Deck d);
    List<Deck> getDeck();
    void takeTest();
}
class Quiz implements Quizzes{
    private List<Deck> decks = new ArrayList<>();
    public Quiz(){}
    @Override
    public void takeTest(){
        for (Deck deck : decks){
            System.out.println(deck.toString());
            System.out.println("Press enter to continue");
        }
    }
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
        Collections.shuffle(decks);
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
    private long time;
    public TimeQuiz(Quizzes quiz){
        super(quiz);
        this.decks = decoratedquiz.getDeck();
    }
    private void setTime(long timeQuiz){
        this.time = timeQuiz;
    }

    @Override
    public void takeTest(){
        long startTime = System.currentTimeMillis();
        for (Deck deck : decks){
            System.out.println(deck.toString());
            System.out.println("Press enter to continue");

        }
        long endTime = System.currentTimeMillis();
        time = endTime - startTime;
        System.out.println("The test takes "+ time);
    }
}

public class DecoratorPatternTest{
    public  static void main(String[] args){
        //Normal test
        Quizzes quizz = new Quiz();
        quizz.takeTest();
        //If you want to take a test with time
        quizz = new TimeQuiz(quizz);
        quizz.takeTest();
    }
}
