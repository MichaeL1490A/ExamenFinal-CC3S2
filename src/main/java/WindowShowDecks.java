import javax.management.Descriptor;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WindowShowDecks {
    private JFrame showDeck;
    private JLabel title = new JLabel("Tus mazos");
    private JPanel contentPanel = new JPanel();
    private JButton buttonMain = new JButton("Inicio");

    private JButton buttonCreateDeck = new JButton("Crear mazo");

    private JTable table;
    private List<Deck> decks;

    WindowShowDecks(){
        showDeck = new JFrame();
        showDeck.setSize(500,500);
        showDeck.setLocationRelativeTo(null);
        showDeck.setLayout(null);
        showDeck.setVisible(true);
        showDeck.setResizable(false);
        showDeck.setContentPane(contentPanel);
        contentPanel.setLayout(null);

        startComponents();

        showDeck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void startComponents(){
        addTitleOfWindow();
        JTable1();
        addButtonBack();
        addButtonCreateDeck();
        addButtonShowDeck();
    }
    private void addTitleOfWindow(){
        ImageIcon iconImage = new ImageIcon("Media/icon.png");
        JLabel icon = new JLabel();
        icon.setBounds(80,30,40,50);
        icon.setIcon(new ImageIcon(iconImage.getImage().getScaledInstance(icon.getWidth(), icon.getHeight(), Image.SCALE_SMOOTH)));
        contentPanel.add(icon);

        title.setBounds(140,30,380,50);
        title.setFont(new Font("cooper black",1,40));
        contentPanel.add(title);
    }

    private void JTable1() {
        String name;
        String description;
        FileInputStream fi;
        ObjectInputStream oi;
        decks = new ArrayList<>();
        File folder = new File("Data");
        Deck dtemp;
        for(File file : folder.listFiles()){
            if(!file.isDirectory()) {
                try {
                    String rut = "Data\\"+file.getName();
                    fi = new FileInputStream(new File(rut));
                    oi = new ObjectInputStream(fi);
                    dtemp = (Deck) oi.readObject();
                    decks.add(dtemp);
                    oi.close();
                    fi.close();
                } catch (IOException ioe) {
                    System.err.println("Error opening file");
                }
                catch(ClassNotFoundException cnfe){
                    System.err.println("Object readed is not a Deck");
                }
            }
        }
        String col[] = {"Name", "Description"};
        DefaultTableModel tableModel = new DefaultTableModel(col,0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        table = new JTable(tableModel);
        for (Deck d :decks){
            name = d.getName();
            description = d.getDescription();
            Object[] data = {name,description};
            tableModel.addRow(data);
        }
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(50,100,400,280);
        contentPanel.add(scrollPane);
        scrollPane.setViewportView(table);
    }
    private void addButtonBack(){
        buttonMain.setBounds(300,400,100,30);
        //buttonBack.setFocusable(true);
        contentPanel.add(buttonMain);
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
        contentPanel.add(buttonCreateDeck);
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

    private void addButtonShowDeck(){
        JButton buttonShowDeck = new JButton();
        buttonShowDeck.setText("Ver mazo");
        buttonShowDeck.setBounds(200,400,100,30);
        contentPanel.add(buttonShowDeck);
        ActionListener actionButtonShowDeck = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Deck deck;
                if(e.getSource()==buttonShowDeck){
                    deck = recoverDeck();
                    if(deck.getName().equals("")){
                        JOptionPane.showMessageDialog(showDeck, "No seleccionaste un mazo");
                    }
                    else {
                        showDeck.dispose();
                        WindowShowSelectedDeck windowShowSelectedDeck = new WindowShowSelectedDeck(deck);
                    }
                }
            }
        };
        buttonShowDeck.addActionListener(actionButtonShowDeck);
    }
    private Deck recoverDeck(){
        try {
            String name = table.getModel().getValueAt(table.getSelectedRow(), 0).toString();
            String description = table.getModel().getValueAt(table.getSelectedRow(), 1).toString();
            for(Deck d : decks){
                if(d.getName().equals(name) && d.getDescription().equals(description)){
                    return d;
                }
            }
        }catch (Exception e) {
            System.out.println("Selecciona un mazo");
        }
        return new Deck();
    }
}