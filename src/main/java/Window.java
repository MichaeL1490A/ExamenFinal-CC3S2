import javax.swing.*;
import java.awt.*;

class Window extends JFrame {
    private JPanel panel;
    private JLabel title = new JLabel("FLASHCARDS");
    private JButton createDeck;
    private JButton showDeck;

    private JButton studyDeck;
    public Window(){
        setSize(500,500);
        setTitle("FLASHCARDS");
        setResizable(false);
        setLocationRelativeTo(null);

        iniciarComponentes();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void iniciarComponentes(){
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
        panel.add(createDeck);

        showDeck = new JButton("Mostrar mazos");
        showDeck.setBounds(270,105,120,50);
        panel.add(showDeck);

        studyDeck = new JButton("Estudiar mazo");
        studyDeck.setBounds(60,200,120,50);
        panel.add(studyDeck);

    }
}