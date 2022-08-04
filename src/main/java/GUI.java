import javax.swing.*;
import java.awt.*;

public class GUI {
    public static void main(String[] args){
        Ventana v1 = new Ventana();
        v1.setVisible(true);
    }
}

class Ventana extends JFrame{
    public JPanel panel;
    public Ventana(){
        setSize(500,500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("FLASHCARDS");
        //setLocation(100,200);
        //setBounds(100,200,500,500);
        setLocationRelativeTo(null);
        iniciarComponentes();
    }
    private void iniciarComponentes(){
        colocarPaneles();
        colocarEtiquetas();
        colocarBotones();
    }
    private void colocarPaneles(){
        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }
    private void colocarEtiquetas(){
        JLabel etiqueta = new JLabel();
        etiqueta.setText("FLASHCARDS");
        etiqueta.setBounds(110,30,300,80);
        //etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
        etiqueta.setForeground(Color.BLACK);
        etiqueta.setFont(new Font("cooper black",0,40));
        panel.add(etiqueta);
    }
    private void colocarBotones(){
        JButton boton1 = new JButton("Crear mazo");
        JButton boton2 = new JButton("Mostrar mazos");
        boton1.setBounds(60,100,120,50);
        boton2.setBounds(270,105,120,50);
        panel.add(boton1);
        panel.add(boton2);
    }
}