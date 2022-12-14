import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
public class Deck implements Serializable {
    private String name;
    private String description;
    public List<Flashcard> deck = new ArrayList<>();
    public Deck(String name, String description){
        this.name = name;
        this.description = description;
    }
    public Deck(){
        this.name="";
        this.description="";
    }
    public String getName(){
        return this.name;
    }
    public String getDescription(){
        return this.description;
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
    public void getInfo(){
        System.out.println(name+" "+description);
    }
    public Deck returnDeck(){
        return this;
    }
    @Override
    public String toString() {
        return "Name:" + name + "\nDescripcion: " + description;
    }
}
