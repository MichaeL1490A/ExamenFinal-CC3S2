import java.util.List;
public class Deck {
    public String name;
    public String description;
    public List<Flashcard> deck;
    public Deck(String name, String description){
        this.name = name;
        this.description = description;
    }
    public void showFlashcard(){
        for(Flashcard f : deck) {
            System.out.println(f);
        }
    }
    public void addFlashcard(Flashcard f){
        deck.add(f);
    }
    public void deleteQuestion(Flashcard f){
        deck.remove(f);
    }
}
