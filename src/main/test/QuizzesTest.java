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

        @RepeatedTest(3)
        @DisplayName("Trataremos de comprobar repitiendo que no pueden coincidir tras aleatorizar un Quiz")
        public void testRandomizeQuiz(){
            Deck deck2 = new Deck("Asd", "1234");
            Deck deck3 = new Deck("Asdf", "12345");
            Deck deck4 = new Deck("Asdfe", "123456");
            List<Deck> d = new ArrayList<>();
            d.add(deck);
            d.add(deck2);
            d.add(deck3);
            d.add(deck4);
            quiz.addDeck(deck2);
            quiz.addDeck(deck3);
            quiz.addDeck(deck4);
            assertNotEquals(d, quiz.randomize());
        }
    }
}
