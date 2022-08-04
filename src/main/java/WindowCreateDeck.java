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
        //labelAnswer.setHorizontalAlignment(SwingConstants.CENTER);
        nameDeck.setFont(new Font("cooper black",1,12));
        panelCreateDeck.add(nameDeck);

        JTextField fieldNameDeck = new JTextField();
        fieldNameDeck.setBounds(250, 100, 200, 50);
        fieldNameDeck.setFont(new Font("cooper black",0,12));
        panelCreateDeck.add(fieldNameDeck);
    }

    private void addQuestion(){
        JLabel labelQuestion = new JLabel("Pregunta ");
        labelQuestion.setBounds(50,200,100,50);
        labelQuestion.setFont(new Font("cooper black",1,12));
        panelCreateDeck.add(labelQuestion);

        JTextArea textQuestion = new JTextArea();
        textQuestion.setBounds(50,300,400,100);
        textQuestion.setBackground(Color.BLACK);
        textQuestion.setForeground(Color.WHITE);
        textQuestion.setFont(new Font("cooper black",1,12));
        panelCreateDeck.add(textQuestion);
    }

    private void addAnswer(){
        JLabel labelAnswer = new JLabel("Respuesta ");
        labelAnswer.setBounds(50,400,100,50);
        labelAnswer.setFont(new Font("cooper black",1,12));
        panelCreateDeck.add(labelAnswer);

        JTextArea textAnswer = new JTextArea();
        textAnswer.setBounds(50,450,400,100);
        textAnswer.setBackground(Color.BLACK);
        textAnswer.setForeground(Color.WHITE);
        textAnswer.setFont(new Font("cooper black",1,12));
        panelCreateDeck.add(textAnswer);
    }

    private void addButtonBack(){
        buttonBack = new JButton("Volver");
        buttonBack.setBounds(400,400,120,50);
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
        buttonSave.setBounds(200,400,120,50);
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
