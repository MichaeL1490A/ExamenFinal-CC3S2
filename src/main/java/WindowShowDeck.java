import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WindowShowDeck{
    private JFrame showDeck;
    private JLabel titleShowDeck;
    private JButton buttonBack;
    private JPanel contentPane = new JPanel();
    WindowShowDeck(){
        showDeck = new JFrame();
        showDeck.setSize(500,500);
        showDeck.setLayout(null);
        showDeck.setVisible(true);
        showDeck.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane.setLayout(null);
        startComponents();
        showDeck.setContentPane(contentPane);

    }
    private void startComponents(){
        placeButtons();
        addTitleOfWindow();
        JTable1();

    }
    private void addTitleOfWindow(){
        ImageIcon iconImage = new ImageIcon("Media/icon.png");
        JLabel icon = new JLabel();
        icon.setBounds(80,30,40,50);
        icon.setIcon(new ImageIcon(iconImage.getImage().getScaledInstance(icon.getWidth(), icon.getHeight(), Image.SCALE_SMOOTH)));
        contentPane.add(icon);
        titleShowDeck = new JLabel("Mostrando mazos");
        titleShowDeck.setBounds(120,30,300,50);
        titleShowDeck.setHorizontalAlignment(SwingConstants.CENTER);
        titleShowDeck.setFont(new Font("cooper black",1,40));
        contentPane.add(titleShowDeck);
    }
    public void JTable1() {
        ObjectInputStream input;
        String[] column= {"Nombre", "Descripcion"};
        List<Deck> decks = new ArrayList<>();
        File folder = new File("Data");
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
        String[][] d = {{"123","asdasd"},{"1231","123123"}};

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(130, 300, 180, 130);
        contentPane.add(scrollPane);
        //JTable jt1 = new JTable(data,column);
        //scrollPane.setViewportView(jt1);
    }
    private void placeButtons(){
        buttonBack = new JButton("Volver");
        buttonBack.setBounds(300,400,120,50);
        buttonBack.setFocusable(false);
        contentPane.add(buttonBack);
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
class frmArrayListJTable{
    DefaultTableModel modelo = new DefaultTableModel();
    public void CargaAutomatica(){
        ArrayList<Object> columns = new ArrayList<Object>();
        columns.add("Nombre");
        columns.add("Descripcion");
        for(Object column : columns){
            modelo.addColumn(column);
        }
        //this.tabladatos.setModel(modelo);
    }
}