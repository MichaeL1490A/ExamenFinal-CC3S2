import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowCreateDeck{
    private JFrame createDeck;
    private JLabel titleCreateDeck;
    private JLabel nameDeck;
    private JButton buttonBack;
    private JButton buttonSave;
    WindowCreateDeck(){
        createDeck = new JFrame();
        createDeck.setSize(500,500);
        createDeck.setLayout(null);
        createDeck.setVisible(true);
        createDeck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startComponents();
    }
    private void startComponents(){
        placeButtons();
        addTitleOfWindow();
        addNameOfDeck();
        addQuestion();
        addAnswer();
    }
    private void addTitleOfWindow(){
        ImageIcon iconImage = new ImageIcon("Media/icon.png");
        JLabel icon = new JLabel();
        icon.setBounds(80,30,40,50);
        icon.setIcon(new ImageIcon(iconImage.getImage().getScaledInstance(icon.getWidth(), icon.getHeight(), Image.SCALE_SMOOTH)));
        createDeck.add(icon);

        titleCreateDeck = new JLabel("CREAR MAZO");
        titleCreateDeck.setBounds(120,30,300,50);
        titleCreateDeck.setHorizontalAlignment(SwingConstants.CENTER);
        titleCreateDeck.setFont(new Font("cooper black",1,40));
        createDeck.add(titleCreateDeck);
    }

    private void addNameOfDeck(){
        nameDeck = new JLabel("Nombre del mazo: ");
        nameDeck.setBounds(50,100,300,50);
        createDeck.add(nameDeck);
        JTextField fieldNameDeck = new JTextField();
        fieldNameDeck.setBounds(200, 100, 200, 35);
        createDeck.add(fieldNameDeck);
    }

    private void addQuestion(){
        JLabel labelQuestion = new JLabel("Pregunta: ");
        labelQuestion.setBounds(50,150,200,50);
        createDeck.add(labelQuestion);

        JTextField textQuestion = new JTextField();
        textQuestion.setBounds(200,150,200,35);
        createDeck.add(textQuestion);
    }

    private void addAnswer(){
        JLabel labelAnswer = new JLabel("Respuesta: ");
        labelAnswer.setBounds(50,200,200,50);
        createDeck.add(labelAnswer);

        JTextField textAnswer = new JTextField();
        textAnswer.setBounds(200,200,200,35);
        createDeck.add(textAnswer);
    }
    private void placeButtons(){

        buttonBack = new JButton("Volver");
        buttonBack.setBounds(300,400,120,50);
        buttonBack.setFocusable(false);
        createDeck.add(buttonBack);

        buttonSave = new JButton("Guardar");
        buttonSave.setBounds(100,400,120,50);
        buttonSave.setFocusable(false);
        createDeck.add(buttonSave);
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==buttonBack){
                    createDeck.dispose();
                    Window window = new Window();
                }
                else if(e.getSource()==buttonSave){

                }
            }

        };
        buttonBack.addActionListener(actionListener);
        buttonSave.addActionListener(actionListener);
    }
}
