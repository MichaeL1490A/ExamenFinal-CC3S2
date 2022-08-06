import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WindowCreateDeck{
    private JFrame createDeck;
    private JLabel titleCreateDeck;
    private JLabel nameDeck;
    private JLabel descriptionDeck;
    private JButton buttonMain;
    private JButton buttonSave;
    /*MOVER A MOSTRAR MAZOS
    private JTextField textQuestion;
    private JTextField textAnswer;

     */
    private JTextField fieldNameDeck;
    private JTextField fieldDescriptionDeck;
    WindowCreateDeck(){
        createDeck = new JFrame();
        createDeck.setSize(500,500);
        createDeck.setLocationRelativeTo(null);
        createDeck.setLayout(null);
        createDeck.setVisible(true);
        createDeck.setResizable(false);

        startComponents();

        createDeck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void startComponents(){
        placeButtons();
        addTitleOfWindow();
        addNameOfDeck();
        addDescriptionOfDeck();
    }
    private void addTitleOfWindow(){
        ImageIcon iconImage = new ImageIcon("Media/icon.png");
        JLabel icon = new JLabel();
        icon.setBounds(80,30,40,50);
        icon.setIcon(new ImageIcon(iconImage.getImage().getScaledInstance(icon.getWidth(), icon.getHeight(), Image.SCALE_SMOOTH)));
        createDeck.add(icon);

        titleCreateDeck = new JLabel("CREAR MAZO");
        titleCreateDeck.setBounds(140,30,300,50);
        titleCreateDeck.setFont(new Font("cooper black",1,40));
        createDeck.add(titleCreateDeck);
    }

    private void addNameOfDeck(){
        nameDeck = new JLabel("Nombre del mazo: ");
        nameDeck.setBounds(50,100,300,50);
        createDeck.add(nameDeck);
        fieldNameDeck = new JTextField();
        fieldNameDeck.setBounds(200, 100, 200, 35);
        createDeck.add(fieldNameDeck);
    }
    private void addDescriptionOfDeck(){
        descriptionDeck = new JLabel("Descripcion del mazo: ");
        descriptionDeck.setBounds(50,150,200,50);
        createDeck.add(descriptionDeck);
        fieldDescriptionDeck = new JTextField();
        fieldDescriptionDeck.setBounds(200, 150, 200, 35);
        createDeck.add(fieldDescriptionDeck);
    }

    /*MOVER A MOSTRAR MAZOS
    private void addQuestion(){
        JLabel labelQuestion = new JLabel("Pregunta: ");
        labelQuestion.setBounds(50,150,200,50);
        createDeck.add(labelQuestion);
        textQuestion = new JTextField();
        textQuestion.setBounds(200,150,200,35);
        createDeck.add(textQuestion);
    }

    private void addAnswer(){
        JLabel labelAnswer = new JLabel("Respuesta: ");
        labelAnswer.setBounds(50,200,200,50);
        createDeck.add(labelAnswer);

        textAnswer = new JTextField();
        textAnswer.setBounds(200,200,200,35);
        createDeck.add(textAnswer);
    }

     */

    public void makeDeck(){
        /*MOVER A MOSTRAR MAZOS AGREGAR TARJETA
        FlashcardCreator flashcardCreator = new FlashcardCreator();
        WordFlashcardBuilder FlashcardBuilder = new WordFlashcardBuilder();

        FlashcardBuilder.setQuestion(new Question(textQuestion.getText()));
        FlashcardBuilder.setAnswer(new Word(textQuestion.getText()));

        flashcardCreator.constructWordFlashcard(FlashcardBuilder);
        Flashcard flashcard = FlashcardBuilder.getResult();

         */
        Deck deck = new Deck(fieldNameDeck.getText(),fieldDescriptionDeck.getText());
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Data\\"+fieldNameDeck.getText()+".dat"));
            output.writeObject(deck);
            output.close();
        }
        catch(IOException ioe){
            System.err.println("Error saving to file");
        }
    }
    private void placeButtons(){

        buttonMain = new JButton("Inicio");
        buttonMain.setBounds(300,400,120,50);
        buttonMain.setFocusable(false);
        createDeck.add(buttonMain);

        buttonSave = new JButton("Guardar");
        buttonSave.setBounds(100,400,120,50);
        buttonSave.setFocusable(false);
        createDeck.add(buttonSave);
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==buttonMain){
                    createDeck.dispose();
                    Window window = new Window();
                }
                else if(e.getSource()==buttonSave){
                    makeDeck();
                }
            }

        };
        buttonMain.addActionListener(actionListener);
        buttonSave.addActionListener(actionListener);
    }
}
