import java.util.List;

public class GUI {
    public List<Deck> Decks;

    public void addDeck(Deck d){
        Decks.add(d);
    }
    public void showDeck(){
        for(Deck decks : Decks){
            System.out.println(decks.name);
            decks.showFlashcard();
        }
    }
    public void deleteDeck(Deck d){
        Decks.remove(d);
    }
}
