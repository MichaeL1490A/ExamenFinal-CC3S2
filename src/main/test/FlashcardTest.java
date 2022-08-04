import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class FlashcardTest {

    @DisplayName("Dado que creamos un Word Flashcard")
    @Nested
    class WordFlashcardTest{
        private Flashcard flash;

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
        @DisplayName("Confirmacion de funcionamiento de strings")
        public void testWordFlashcardTerms() {
            assertEquals("Amogus",flash.getQuestion().toString());
            assertEquals("SUS", flash.getAnswer().toString());
        }


    }

}
