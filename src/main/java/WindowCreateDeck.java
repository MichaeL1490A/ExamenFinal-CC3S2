import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WindowCreateDeck{
    private JFrame createDeck;
    private JLabel title;
    private JLabel nameDeck;
    private JLabel descriptionDeck;
    private JButton buttonMain;
    private JButton buttonSave;
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

        title = new JLabel("CREAR MAZO");
        title.setBounds(140,30,300,50);
        title.setFont(new Font("cooper black",1,40));
        createDeck.add(title);
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
            FileOutputStream f = new FileOutputStream(new File("Data\\"+fieldNameDeck.getText()+".dat"));
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(deck);
            o.close();
            f.close();
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