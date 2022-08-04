import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {

    private Deck deck;
    private Flashcard flash;

    @DisplayName("Creamos un deck")
    @Nested
    class DeckT {

        @BeforeEach
        void setUp() {
            String name = "Save";
            String desc = "Someone save me pls";
            deck = new Deck(name, desc);
            FlashcardCreator flashy = new FlashcardCreator();
            WordFlashcardBuilder wordy = new WordFlashcardBuilder();
            flashy.constructWordFlashcard(wordy);
            Question question = new Question("Amogus");
            Answer answer = new Word("SUS");
            wordy.setQuestion(question);
            wordy.setAnswer(answer);
            flash = wordy.getResult();
        }

        @DisplayName("Revisando todos los parametros del deck")
        @Test
        public void testDeckTerms() {
            assertAll("Tanto el name como la descripcion deberian ser correctos",
                    () -> assertEquals("Save", deck.name),
                    () -> assertEquals("Someone save me pls", deck.description)
            );
        }

        @DisplayName("Confirmando que se añada un flashcard")
        @Test
        public void testAddFlashcard() {
            deck.addFlashcard(flash);
            assertEquals(flash.toString() + "\n", deck.showFlashcard());
        }
    }
}
