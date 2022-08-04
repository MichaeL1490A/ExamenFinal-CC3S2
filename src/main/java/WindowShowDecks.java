import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WindowShowDecks {
    private JFrame showDeck;
    private JLabel titleShowDeck = new JLabel("Tus mazos");
    private JPanel contentPane = new JPanel();
    private JButton buttonMain = new JButton("Inicio");

    private JButton buttonCreateDeck = new JButton("Crear mazo");
    
    WindowShowDecks(){
        showDeck = new JFrame();
        showDeck.setSize(500,500);
        showDeck.setLocationRelativeTo(null);
        showDeck.setLayout(null);
        showDeck.setVisible(true);
        showDeck.setResizable(false);
        showDeck.setContentPane(contentPane);
        contentPane.setLayout(null);

        startComponents();

        showDeck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void startComponents(){
        addTitleOfWindow();
        JTable1();
        addButtonBack();
        addButtonCreateDeck();
    }
    private void addTitleOfWindow(){
        ImageIcon iconImage = new ImageIcon("Media/icon.png");
        JLabel icon = new JLabel();
        icon.setBounds(80,30,40,50);
        icon.setIcon(new ImageIcon(iconImage.getImage().getScaledInstance(icon.getWidth(), icon.getHeight(), Image.SCALE_SMOOTH)));
        contentPane.add(icon);

        titleShowDeck.setBounds(120,30,380,50);
        //titleShowDeck.setHorizontalAlignment(SwingConstants.CENTER);
        titleShowDeck.setFont(new Font("cooper black",1,40));
        contentPane.add(titleShowDeck);
    }
    public void JTable1() {
        ObjectInputStream input;
        String[] column= {"Nombre", "Descripcion", "Ver mazo", "Eliminar Mazo"};
        String[][] data = {};
        ArrayList<String> data1;
        List<Deck> decks = new ArrayList<>();
        File folder = new File("Data");
        for(String[] d : data){
           // d;
        }
        for(File file : folder.listFiles()){
            if(!file.isDirectory()) {
                try {
                    String rut = "Data\\"+file.getName();
                    input = new ObjectInputStream(new FileInputStream(rut));
                    decks.add((Deck) input.readObject());

                } catch (IOException ioe) {
                    System.err.println("Error opening file");
                }
                catch(ClassNotFoundException cnfe){
                    System.err.println("Object readed is not a Deck");
                }
            }
        }
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(50, 100, 400, 280);
        contentPane.add(scrollPane);
        JTable jt1 = new JTable(data,column);
        scrollPane.setViewportView(jt1);
    }
    private void addButtonBack(){
        buttonMain.setBounds(300,400,100,30);
        //buttonBack.setFocusable(true);
        contentPane.add(buttonMain);
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==buttonMain){
                    showDeck.dispose();
                    Window window = new Window();
                }
            }

        };
        buttonMain.addActionListener(actionListener);
    }
    private void addButtonCreateDeck(){
        buttonCreateDeck.setBounds(100,400,100,30);
        contentPane.add(buttonCreateDeck);
        ActionListener actionButtonCreate = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==buttonCreateDeck){
                    showDeck.dispose();
                    WindowCreateDeck windowCreateDeck = new WindowCreateDeck();
                }
            }
        };
        buttonCreateDeck.addActionListener(actionButtonCreate);
    }


}