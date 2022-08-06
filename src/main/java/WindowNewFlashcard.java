import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowNewFlashcard {
    private JFrame showNewFlashcard;
    private JPanel contentPanel = new JPanel();
    private JLabel title = new JLabel("Nuevo Flashcard");
    private JLabel labelQuestion = new JLabel("Pregunta: ");
    private JTextArea areaQuestion = new JTextArea();
    private JLabel labelAnswer = new JLabel("Respuesta: ");
    private JTextArea areaAnswer = new JTextArea();
    private JButton buttonSave = new JButton("Guardar");
    private JButton buttonBack = new JButton("Volver");
    private Deck fdeck;
    WindowNewFlashcard(Deck fdeck){
        this.fdeck = fdeck;
        showNewFlashcard = new JFrame();
        showNewFlashcard.setSize(500, 500);
        showNewFlashcard.setLocationRelativeTo(null);
        showNewFlashcard.setVisible(true);
        showNewFlashcard.setLayout(null);
        showNewFlashcard.setResizable(false);
        showNewFlashcard.setContentPane(contentPanel);
        contentPanel.setLayout(null);

        startsComponents();

        showNewFlashcard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void startsComponents() {
        addTitleOfWindow();
        addAreaQuestion();
        addAreaAnswer();
        addButtonBack();
        addButtonSave();
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
    }


    private void addAreaQuestion(){
        labelQuestion.setBounds(50,150,200,50);
        contentPanel.add(labelQuestion);

        areaQuestion.setBounds(200,150,200,35);
        contentPanel.add(areaQuestion);
    }

    private void addAreaAnswer(){
        labelAnswer.setBounds(50,200,200,50);
        contentPanel.add(labelAnswer);

        areaAnswer.setBounds(200,200,200,35);
        contentPanel.add(areaAnswer);
    }

    private void addButtonSave() {
        buttonSave.setBounds(100, 400, 100, 30);
        contentPanel.add(buttonSave);

/*        ActionListener actionButtonSave = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == buttonSave) {
                    showNewFlashcard.dispose();
                    WindowStudyDeck windowStudyDeck = new WindowStudyDeck();
                }
            }
        };
        buttonSave.addActionListener(actionButtonSave); */
    }



    private void addButtonBack(){
        buttonBack.setBounds(300,400,100,30);
        //buttonBack.setFocusable(true);
        contentPanel.add(buttonBack);
        ActionListener actionButtonBack = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==buttonBack){
                    showNewFlashcard.dispose();
                    WindowShowSelectedDeck windowShowSelectedDeck = new WindowShowSelectedDeck(fdeck);
                }
            }

        };
        buttonBack.addActionListener(actionButtonBack);
    }


}
