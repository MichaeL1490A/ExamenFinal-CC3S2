import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Window extends JFrame {
    private JPanel panel;
    private JPanel panel2;
    private JLabel title = new JLabel("FLASHCARDS");
    private JButton createDeck;
    private JButton showDeck;

    private JButton studyDeck;
    public Window(){
        setSize(500,500);
        setTitle("FLASHCARDS");
        setResizable(false);
        setLocationRelativeTo(null);

        startComponents();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void startComponents(){
        placePanels();
        placeLabels();
        placeButtons();
    }
    private void placePanels(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        this.getContentPane().add(panel);
    }
    private void placeLabels(){
        ImageIcon iconImage = new ImageIcon("Media/icon.png");
        JLabel icon = new JLabel();
        icon.setBounds(80,30,40,50);
        icon.setIcon(new ImageIcon(iconImage.getImage().getScaledInstance(icon.getWidth(), icon.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(icon);

        title.setBounds(120,30,300,50);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("cooper black",1,40));
        panel.add(title);
    }
    private void placeButtons(){
        createDeck = new JButton("Crear mazo");
        createDeck.setBounds(60,100,120,50);
        //createDeck.setBackground(new Color(0,220,220, 0));
        panel.add(createDeck);
        ActionListener actionCreteDeck = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                WindowCreateDeck windowCreateDeck = new WindowCreateDeck();
                panel.setVisible(false);
                panel2 = windowCreateDeck.showPanelCreateDeck(panel);
                panel2.setVisible(true);
                getContentPane().add(panel2);
            }
        };
        createDeck.addActionListener(actionCreteDeck);





        showDeck = new JButton("Mostrar mazos");
        showDeck.setBounds(270,105,120,50);
        panel.add(showDeck);

        studyDeck = new JButton("Estudiar mazo");
        studyDeck.setBounds(60,200,120,50);
        panel.add(studyDeck);
        ActionListener actionStudyDeck = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                WindowStudyDeck windowStudyDeck = new WindowStudyDeck();
                panel.setVisible(false);
                panel2 = windowStudyDeck.showWindowStudyDeck(panel);
                panel2.setVisible(true);
                getContentPane().add(panel2);
            }
        };
        studyDeck.addActionListener(actionStudyDeck);

    }
}