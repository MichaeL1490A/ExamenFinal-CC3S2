import javax.swing.*;
import java.awt.*;

public class WindowCreateDeck extends JFrame {
    private JPanel panelCreateDeck;
    private JLabel titleCreateDeck = new JLabel("CREAR MAZO");
    public JPanel showPanelCreateDeck(){
        startComponents();
        placeLabels();
        return panelCreateDeck;
    }

    private void startComponents(){
        panelCreateDeck = new JPanel();
        panelCreateDeck.setLayout(null);
        panelCreateDeck.setBackground(Color.white);
    }
    private void placeLabels(){
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







}
