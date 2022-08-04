import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowStudyDeck {
    private JPanel panelStudyDeck;
    private JPanel panelMain;
    private JButton buttonBack;
    private JButton buttonNext;
    private JButton buttonPrevious;

    private JLabel titleStudyDeck = new JLabel("ESTUDIAR MAZO");
    private JTextArea areaQuestion = new JTextArea();



    public JPanel showWindowStudyDeck(JPanel panel){
        panelMain = panel;
        startComponents();
        return panelStudyDeck;
    }

    private void startComponents(){
        panelStudyDeck = new JPanel();
        panelStudyDeck.setLayout(null);
        panelStudyDeck.setBackground(Color.white);
        addTitleOfWindow();
        addButtonBack();
        addAreaQuestion();
        addButtonPrevious();
        addButtonNext();
    }

    private void addTitleOfWindow(){
        ImageIcon iconImage = new ImageIcon("Media/icon.png");
        JLabel icon = new JLabel();
        icon.setBounds(80,30,40,50);
        icon.setIcon(new ImageIcon(iconImage.getImage().getScaledInstance(icon.getWidth(), icon.getHeight(), Image.SCALE_SMOOTH)));
        panelStudyDeck.add(icon);

        titleStudyDeck.setBounds(120,30,350,50);
        titleStudyDeck.setHorizontalAlignment(SwingConstants.CENTER);
        titleStudyDeck.setFont(new Font("cooper black",1,40));
        panelStudyDeck.add(titleStudyDeck);
    }

    private void addAreaQuestion(){
        areaQuestion.setBounds(100,100,300,200);
        areaQuestion.setEnabled(false);
        areaQuestion.setText("Aca ira la pregunta");
        panelStudyDeck.add(areaQuestion);
    }

    private void addButtonPrevious(){
        buttonPrevious = new JButton();
        buttonPrevious.setBounds(100,400,150, 50);
        ImageIcon iconPrevious = new ImageIcon("Media/imagePrevious.png");
        buttonPrevious.setIcon(new ImageIcon(iconPrevious.getImage().getScaledInstance(buttonPrevious.getWidth(), buttonPrevious.getHeight(), Image.SCALE_SMOOTH)));
        //buttonPrevious.setBorder(null);
        panelStudyDeck.add(buttonPrevious);

    }

     private void addButtonNext(){
        buttonNext = new JButton();
        buttonNext.setBounds(300,400,150, 50);
        ImageIcon iconNext = new ImageIcon("Media/imageNext.png");
        buttonNext.setIcon(new ImageIcon(iconNext.getImage().getScaledInstance(buttonNext.getWidth(), buttonNext.getHeight(), Image.SCALE_SMOOTH)));
        //buttonNext.setBorder(null);
        panelStudyDeck.add(buttonNext);

    }



    private void addButtonBack(){
        buttonBack = new JButton("Volver");
        buttonBack.setBounds(400,400,120,50);
        panelStudyDeck.add(buttonBack);
        ActionListener actionBack = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                panelStudyDeck.setVisible(false);
                panelMain.setVisible(true);
            }
        };
        buttonBack.addActionListener(actionBack);
    }

}
