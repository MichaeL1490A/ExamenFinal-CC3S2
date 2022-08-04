import java.util.ArrayList;
import java.util.List;
public class Deck {
    public String name;
    public String description;
    public List<Flashcard> deck = new ArrayList<>();
    public Deck(String name, String description){
        this.name = name;
        this.description = description;
    }
    public String showFlashcard(){
        StringBuilder info = new StringBuilder();
        for(Flashcard f : deck) {
            info.append(f.toString()).append("\n");
        }
        return info.toString();
    }
    public void addFlashcard(Flashcard f){
        deck.add(f);
    }
    public void deleteFlashcard(Flashcard f){
        deck.remove(f);
    }
}
