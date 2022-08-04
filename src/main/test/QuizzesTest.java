import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class QuizzesTest {

    private Deck deck;
    private Quiz quiz;

    @DisplayName("Test para el caso simple Quiz")
    @Nested
    class QuizTest{

        @BeforeEach
        void setUp(){
            quiz = new Quiz();
            deck = new Deck("Save", "Someone save me pls");
            quiz.addDeck(deck);
        }

        @Test
        @DisplayName("Confirmamos que se pueda añadir un Deck")
        public void testAddDecktoQuiz(){
            List<Deck> d = new ArrayList<>();
            d.add(deck);
            assertEquals(d, quiz.getDeck());
        }

        @Test
        @DisplayName("Confirmamos que se pueda borrar un Deck")
        public void testDeleteDecktoQuiz(){
            List<Deck> d = new ArrayList<>();
            quiz.deleteDeck(deck);
            assertEquals(d, quiz.getDeck());
        }
    }
}
