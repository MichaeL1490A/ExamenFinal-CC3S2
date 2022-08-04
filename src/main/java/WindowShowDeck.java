import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowShowDeck{
    private JFrame showDeck;
    private JLabel titleShowDeck;
    private JButton buttonBack;
    WindowShowDeck(){
        showDeck = new JFrame();
        showDeck.setSize(500,500);
        showDeck.setLayout(null);
        showDeck.setVisible(true);
        showDeck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startComponents();
    }
    private void startComponents(){
        placeButtons();
        addTitleOfWindow();
    }
    private void addTitleOfWindow(){
        ImageIcon iconImage = new ImageIcon("Media/icon.png");
        JLabel icon = new JLabel();
        icon.setBounds(80,30,40,50);
        icon.setIcon(new ImageIcon(iconImage.getImage().getScaledInstance(icon.getWidth(), icon.getHeight(), Image.SCALE_SMOOTH)));
        showDeck.add(icon);

        titleShowDeck = new JLabel("Mostrando mazos");
        titleShowDeck.setBounds(120,30,300,50);
        titleShowDeck.setHorizontalAlignment(SwingConstants.CENTER);
        titleShowDeck.setFont(new Font("cooper black",1,40));
        showDeck.add(titleShowDeck);
    }
    private void placeButtons(){
        buttonBack = new JButton("Volver");
        buttonBack.setBounds(300,400,120,50);
        buttonBack.setFocusable(false);
        showDeck.add(buttonBack);
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==buttonBack){
                    showDeck.dispose();
                    Window window = new Window();
                }
            }

        };
        buttonBack.addActionListener(actionListener);
    }
}