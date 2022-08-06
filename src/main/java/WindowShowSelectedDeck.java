import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowShowSelectedDeck {
    private JFrame showSelectedDeck;
    private JPanel contentPanel = new JPanel();
    private JLabel titleShowDeck = new JLabel("Mazo");
    private JLabel nameDeck = new JLabel();
    private JButton buttonBack = new JButton("Volver");

    private JButton buttonStudyDeck = new JButton("Estudiar");

    WindowShowSelectedDeck(){
        showSelectedDeck = new JFrame();
        showSelectedDeck.setSize(500,500);
        showSelectedDeck.setLocationRelativeTo(null);
        showSelectedDeck.setVisible(true);
        showSelectedDeck.setLayout(null);
        showSelectedDeck.setResizable(false);
        showSelectedDeck.setContentPane(contentPanel);
        contentPanel.setLayout(null);

        startsComponents();

        showSelectedDeck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void startsComponents(){
        addTitleOfWindow();
        addButtonStudyDeck();
        addButtonBack();

    }

    private void addTitleOfWindow(){
        ImageIcon iconImage = new ImageIcon("Media/icon.png");
        JLabel icon = new JLabel();
        icon.setBounds(80,30,40,50);
        icon.setIcon(new ImageIcon(iconImage.getImage().getScaledInstance(icon.getWidth(), icon.getHeight(), Image.SCALE_SMOOTH)));
        contentPanel.add(icon);

        titleShowDeck.setBounds(140,30,380,50);
        titleShowDeck.setFont(new Font("cooper black",1,40));
        contentPanel.add(titleShowDeck);

        nameDeck.setBounds(100,100,300,20);
        nameDeck.setText("Nombre del mazo");
        nameDeck.setFont(new Font("cooper black",1,20));
        contentPanel.add(nameDeck);
    }

    private void addButtonBack(){
        buttonBack.setBounds(300,400,100,30);
        contentPanel.add(buttonBack);
        ActionListener actionButtonBack = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==buttonBack){
                    showSelectedDeck.dispose();
                    WindowShowDecks windowShowDecks = new WindowShowDecks();
                }
            }

        };
        buttonBack.addActionListener(actionButtonBack);
    }

    private void addButtonStudyDeck(){
        buttonStudyDeck.setBounds(100,400,100,30);
        contentPanel.add(buttonStudyDeck);
        ActionListener actionButtonStudyDeck = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==buttonStudyDeck){
                    showSelectedDeck.dispose();
                    WindowStudyDeck windowStudyDeck = new WindowStudyDeck();
                }
            }
        };
        buttonStudyDeck.addActionListener(actionButtonStudyDeck);
    }

}
