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
            Question question = new Question("Question");
            Answer answer = new Word("Answer");
            wordy.setQuestion(question);
            wordy.setAnswer(answer);
            flash = wordy.getResult();
        }

        @Test
        @DisplayName("Al crear el Flashcard podremos asignar su pregunta y respuesta inicial")
        public void testWordFlashcardTerms() {
            assertAll("Verifica que todos los terminos insertados en el Flashcard son correctamente creados",
                    () -> assertEquals("Question",flash.getQuestion().getQuestion()),
                    () -> assertEquals("Answer", flash.getAnswer().getCorrectAnswer())
            );
        }

        @Test
        @DisplayName("Asi mismo podremos obtener la respuesta a traves del metodo string")
        public void testWordFlashcardStrings() {
            assertEquals("Answer", flash.getAnswer().toString());
        }
        @Test
        @DisplayName("Asi mismo podremos saber si obtenemos la respuesta correcta con el metodo para comparar")
        public void testWordFlashcardCorrect() {
            assertTrue(flash.isCorrect("Answer"));
        }

        @Test
        @DisplayName("Confirmacion de modificacion de terminos para un flashcard")
        public void testWordFlashcardEdit() {
            FlashcardCreator flashy = new FlashcardCreator();
            WordFlashcardBuilder wordy = new WordFlashcardBuilder();
            flashy.constructWordFlashcard(wordy);
            Question question = new Question("2ndQ");
            Answer answer = new Word("2ndA");
            wordy.setQuestion(question);
            wordy.setAnswer(answer);
            flash = wordy.getResult();
            assertAll("Verifica que todos los terminos insertados en el Flashcard son correctamente creados",
                    () -> assertEquals("2ndQ",flash.getQuestion().getQuestion()),
                    () -> assertEquals("2ndA", flash.getAnswer().getCorrectAnswer())
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
            assertAll("Verifica que todos los terminos insertados en el Flashcard son correctamente creados",
                    () -> assertEquals("Amogus",flash.getQuestion().getQuestion()),
                    () -> assertEquals("1", flash.getAnswer().getCorrectAnswer())
            );
        }
        @Test
        @DisplayName("Revisando si afirmativamente se retorna el string del answer correctamente")
        public void testMCFlashcardAnswer() {
            ArrayList<String> inc = new ArrayList<>();
            inc.add("1");
            inc.add("2");
            inc.add("3");
            inc.add("4");
            StringBuilder info = new StringBuilder();
            for (String s : inc){
                info.append(s).append("\n");
            }
            assertEquals(info.toString(), flash.getAnswer().toString());
        }

        @Test
        @DisplayName("Asi mismo podremos saber si obtenemos la respuesta correcta con el metodo para comparar")
        public void testMCFlashcardCorrect() {
            assertTrue(flash.isCorrect("1"));
        }

        @Test
        @DisplayName("Confirmacion de modificacion de terminos para un flashcard")
        public void testWordFlashcardEdit() {
            FlashcardCreator flashy = new FlashcardCreator();
            MCFlashcardBuilder mcfly = new MCFlashcardBuilder();
            flashy.constructMCFlashcard(mcfly);
            Question question = new Question("Who");
            String correct = "5";
            ArrayList<String> incorrect = new ArrayList<>();
            incorrect.add("6");
            incorrect.add("7");
            incorrect.add("8");
            MultipleChoices answer = new MultipleChoices(correct, incorrect);
            mcfly.setQuestion(question);
            mcfly.setAnswer(answer);
            flash = mcfly.getResult();
            assertAll("Verifica que todos los terminos insertados en el Flashcard son correctamente creados",
                    () -> assertEquals("Who",flash.getQuestion().getQuestion()),
                    () -> assertEquals("5", flash.getAnswer().getCorrectAnswer())
            );
        }
    }
}
