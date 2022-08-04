import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window{
    private JFrame menu;
    private JLabel title;
    private JButton createDeck;
    private JButton showDeck;

    Window(){
        menu = new JFrame();
        menu.setSize(500,500);
        menu.setLayout(null);
        menu.setVisible(true);
        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startComponents();
    }
    private void startComponents(){
        placeLabels();
        placeButtons();
    }
    private void placeLabels(){

        title = new JLabel("FLASHCARDS");
        title.setBounds(80,30,350,35);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font("cooper black",1,40));
        menu.add(title);
    }
    private void placeButtons(){

        createDeck = new JButton("Crear mazo");
        createDeck.setBounds(60,100,120,50);
        createDeck.setFocusable(false);
        menu.add(createDeck);

        showDeck = new JButton("Mostrar Mazos");
        showDeck.setBounds(270,100,120,50);
        showDeck.setFocusable(false);
        menu.add(showDeck);

        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==createDeck){
                    menu.dispose();
                    WindowCreateDeck windowCreateDeck = new WindowCreateDeck();

                }
                else if(e.getSource()==showDeck){
                    menu.dispose();
                    WindowShowDeck windowShowDeck = new WindowShowDeck();
                }
            }

        };
        createDeck.addActionListener(actionListener);
        showDeck.addActionListener(actionListener);
    }
}
