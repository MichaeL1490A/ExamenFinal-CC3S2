import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowStudyDeck {
    private JFrame showStudyDeck;
    private JPanel contentPanel = new JPanel();
    private JLabel title = new JLabel("Mazo");
    private JLabel nameDeck = new JLabel();
    private JTextArea areaQuestion = new JTextArea();
    private JTextArea areaAnswer = new JTextArea();
    private JButton buttonSave = new JButton("Ver respuesta");
    private JButton buttonPrevious = new JButton("Anterior");
    private JButton buttonNext = new JButton("Siguiente");
    private JButton buttonBack = new JButton("Volver");


    WindowStudyDeck(){
        showStudyDeck = new JFrame();
        showStudyDeck.setSize(500, 500);
        showStudyDeck.setLocationRelativeTo(null);
        showStudyDeck.setVisible(true);
        showStudyDeck.setLayout(null);
        showStudyDeck.setResizable(false);
        showStudyDeck.setContentPane(contentPanel);
        contentPanel.setLayout(null);

        startsComponents();

        showStudyDeck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    private void startsComponents() {
        addTitleOfWindow();
        addAreaQuestion();
        addAreaAnswer();
        addButtonPrevious();
        addButtonNext();
        addButtonBack();
    }
    private void addTitleOfWindow() {
        ImageIcon iconImage = new ImageIcon("Media/icon.png");
        JLabel icon = new JLabel();
        icon.setBounds(80, 30, 40, 50);
        icon.setIcon(new ImageIcon(iconImage.getImage().getScaledInstance(icon.getWidth(), icon.getHeight(), Image.SCALE_SMOOTH)));
        contentPanel.add(icon);

        title.setBounds(140, 30, 380, 50);
        title.setFont(new Font("cooper black", 1, 40));
        contentPanel.add(title);

        nameDeck.setBounds(100, 100, 300, 20);
        nameDeck.setText("Nombre del mazo");
        nameDeck.setFont(new Font("cooper black", 1, 20));
        contentPanel.add(nameDeck);
    }

    private void addAreaQuestion(){
        areaQuestion.setBounds(100,150,300,100);
        areaQuestion.setText("Pregunta");
        contentPanel.add(areaQuestion);
    }
    private void addAreaAnswer(){

        areaAnswer.setBounds(100,250,300,100);
        areaAnswer.setText("Area de respuesta");
        contentPanel.add(areaAnswer);
    }


    private void addButtonPrevious() {
        buttonPrevious.setBounds(100, 400, 100, 30);
        buttonPrevious.setText("Anterior");
        contentPanel.add(buttonPrevious);
    }
    private void addButtonNext() {
        buttonNext.setBounds(200, 400, 100, 30);
        buttonNext.setText("Siguiente");
        contentPanel.add(buttonNext);
    }


    private void addButtonBack(){
        buttonBack.setBounds(300,400,100,30);
        contentPanel.add(buttonBack);
        ActionListener actionButtonBack = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==buttonBack){
                    showStudyDeck.dispose();
                    WindowShowSelectedDeck windowShowSelectedDeck = new WindowShowSelectedDeck();
                }
            }
        };
        buttonBack.addActionListener(actionButtonBack);
    }

}