import org.junit.jupiter.api.*;

import java.util.ArrayList;

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

    @DisplayName("Dado que creamos un MC Flashcard")
    @Nested
    class MCFlashcardTest{

        @BeforeEach
        void setUp(){
            FlashcardCreator flashy = new FlashcardCreator();
            MCFlashcardBuilder mcfly = new MCFlashcardBuilder();
            flashy.constructMCFlashcard(mcfly);
            Question question = new Question("Amogus");
            String correct = "1";
            ArrayList<String> incorrect = new ArrayList<>();
            incorrect.add("2");
            incorrect.add("3");
            incorrect.add("4");
            MultipleChoices answer = new MultipleChoices(correct, incorrect);
            mcfly.setQuestion(question);
            mcfly.setAnswer(answer);
            flash = mcfly.getResult();
        }

        @Test
        @DisplayName("Al crear el Flashcard podremos asignar su pregunta y respuesta inicial")
        public void testMCFlashcardTerms() {
            ArrayList<String> inc = new ArrayList<>();
            inc.add("1");
            inc.add("2");
            inc.add("3");
            inc.add("4");
            StringBuilder info = new StringBuilder();
            for (String s : inc){
                info.append(s).append("\n");
            }
            assertAll("Verifica que todos los terminos insertados en el Flashcard son correctamente creados",
                    () -> assertEquals("Amogus",flash.getQuestion().toString()),
                    () -> assertEquals("1", flash.getAnswer().getCorrectAnswer()),
                    () -> assertEquals(info.toString(), flash.getAnswer().toString())
            );
        }
    }

}
