import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowCreateDeck extends JFrame {
    private JPanel panelCreateDeck;
    private JPanel panelMain;
    private JButton buttonBack;

    private JLabel titleCreateDeck = new JLabel("CREAR MAZO");
    public JPanel showPanelCreateDeck(JPanel panel){
        panelMain = panel;
        startComponents();
        placeLabels();
        placeButtons();
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

    private void placeButtons(){
        buttonBack = new JButton("Volver");
        buttonBack.setBounds(60,100,120,50);
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







}
