import javax.swing.*;
import java.awt.*;

class Window extends JFrame {
    private JPanel panel;
    private JButton createDeck;
    private JButton showDeck;
    private JLabel title = new JLabel("FLASHCARDS");

    public Window(){
        setSize(500,500);
        setTitle("FLASHCARDS");
        setResizable(false);
        setLocationRelativeTo(null);

        iniciarComponentes();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    private void iniciarComponentes(){
        colocarPaneles();
        colocarEtiquetas();
        colocarBotones();
    }
    private void colocarPaneles(){
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        this.getContentPane().add(panel);
    }
    private void colocarEtiquetas(){
        ImageIcon iconImage = new ImageIcon();
        JLabel icon = new JLabel();

        title.setBounds(110,30,300,80);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("cooper black",1,40));
        panel.add(title);
    }
    private void colocarBotones(){
        createDeck = new JButton("Crear mazo");
        showDeck = new JButton("Mostrar mazos");
        createDeck.setBounds(60,100,120,50);
        showDeck.setBounds(270,105,120,50);
        panel.add(createDeck);
        panel.add(showDeck);
    }
}