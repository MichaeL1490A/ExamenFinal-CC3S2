import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowCreateDeck extends JFrame {
    private JPanel panelCreateDeck;
    private JPanel panelMain;
    private JButton buttonBack;
    private JButton buttonSave;
    private JLabel nameDeck = new JLabel("Nombre del mazo :");
    private JLabel titleCreateDeck = new JLabel("CREAR MAZO");
    public JPanel showPanelCreateDeck(JPanel panel){
        panelMain = panel;
        startComponents();

        return panelCreateDeck;
    }

    private void startComponents(){
        panelCreateDeck = new JPanel();
        panelCreateDeck.setLayout(null);
        panelCreateDeck.setBackground(Color.white);

        addTitleOfWindow();
        addNameOfDeck();
        addQuestion();
        addAnswer();
        addButtonBack();
        addButtonSave();
    }

    private void addTitleOfWindow(){
        ImageIcon iconImage = new ImageIcon("Media/icon.png");
        JLabel icon = new JLabel();
        icon.setBounds(80,30,40,50);
        icon.setIcon(new ImageIcon(iconImage.getImage().getScaledInstance(icon.getWidth(), icon.getHeight(), Image.SCALE_SMOOTH)));
        panelCreateDeck.add(icon);

        titleCreateDeck.setBounds(120,30,300,50);
        titleCreateDeck.setHorizontalAlignment(SwingConstants.CENTER);
        titleCreateDeck.setFont(new Font("cooper black",1,40));
        panelCreateDeck.add(titleCreateDeck);
    }

    private void addNameOfDeck(){
        nameDeck.setBounds(50,100,300,50);
        panelCreateDeck.add(nameDeck);
        JTextField fieldNameDeck = new JTextField();
        fieldNameDeck.setBounds(200, 100, 200, 35);
        panelCreateDeck.add(fieldNameDeck);
    }

    private void addQuestion(){
        JLabel labelQuestion = new JLabel("Pregunta: ");
        labelQuestion.setBounds(50,150,200,50);
        panelCreateDeck.add(labelQuestion);

        JTextField textQuestion = new JTextField();
        textQuestion.setBounds(200,150,200,35);
        panelCreateDeck.add(textQuestion);
    }

    private void addAnswer(){
        JLabel labelAnswer = new JLabel("Respuesta: ");
        labelAnswer.setBounds(50,200,200,50);
        panelCreateDeck.add(labelAnswer);

        JTextField textAnswer = new JTextField();
        textAnswer.setBounds(200,200,200,35);
        panelCreateDeck.add(textAnswer);
    }

    private void addButtonBack(){
        buttonBack = new JButton("Volver");
        buttonBack.setBounds(300,400,120,50);
        panelCreateDeck.add(buttonBack);
        ActionListener actionBack = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCreateDeck.setVisible(false);
                panelMain.setVisible(true);
            }
        };
        buttonBack.addActionListener(actionBack);
    }

    private void addButtonSave(){
        buttonSave = new JButton("Guardar");
        buttonSave.setBounds(100,400,120,50);
        panelCreateDeck.add(buttonSave);
        /*ActionListener actionSave= new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCreateDeck.setVisible(false);
                panelMain.setVisible(true);
            }
        };
        buttonSave.addActionListener(actionSave);*/
    }
}
