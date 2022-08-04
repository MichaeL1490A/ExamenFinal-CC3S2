import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class FlashcardTest {

    private Flashcard flash;

    @DisplayName("Dado que creamos un Word Flashcard")
    @Nested
    class WordFlashcardTest{

        @BeforeEach
        void setUp(){
            FlashcardCreator flashy = new FlashcardCreator();
            WordFlashcardBuilder wordy = new WordFlashcardBuilder();
            flashy.constructWordFlashcard(wordy);
            Question question = new Question("Amogus");
            Answer answer = new Word("SUS");
            wordy.setQuestion(question);
            wordy.setAnswer(answer);
            flash = wordy.getResult();
        }

        @Test
        @DisplayName("Al crear el Flashcard podremos asignar su pregunta y respuesta inicial")
        public void testWordFlashcardTerms() {
            assertAll("Verifica que todos los terminos insertados en el Flashcard son correctamente creados",
                    () -> assertEquals("Amogus",flash.getQuestion().toString()),
                    () -> assertEquals("SUS", flash.getAnswer().toString())
            );
        }
    }

    @DisplayName("Dado que creamos un Word Flashcard")
    @Nested
    class MCFlashcardTest{

        @BeforeEach
        void setUp(){
            FlashcardCreator flashy = new FlashcardCreator();
            WordFlashcardBuilder wordy = new WordFlashcardBuilder();
            flashy.constructWordFlashcard(wordy);
            Question question = new Question("Amogus");
            Answer answer = new Word("SUS");
            wordy.setQuestion(question);
            wordy.setAnswer(answer);
            flash = wordy.getResult();
        }

        @Test
        @DisplayName("Al crear el Flashcard podremos asignar su pregunta y respuesta inicial")
        public void testMCFlashcardTerms() {
            assertAll("Verifica que todos los terminos insertados en el Flashcard son correctamente creados",
                    () -> assertEquals("Amogus",flash.getQuestion().toString()),
                    () -> assertEquals("SUS", flash.getAnswer().toString())
            );
        }
    }

}
