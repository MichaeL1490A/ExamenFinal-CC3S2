import java.util.List;
public class Deck {
    public String name;
    public String description;
    public List<Flashcard> Deck;
    public Deck(String name, String description){
        this.name = name;
        this.description = description;
    }
    public void showFlashcard(){
        for(Flashcard f : Deck) {
            System.out.println(f);
        }
    }
    public void addFlashcard(Flashcard f){
        Deck.add(f);
    }
    public void deleteQuestion(Flashcard f){
        Deck.remove(f);
    }
}
