import javax.swing.JFrame;
public class GUI {
    public static void main(String[] args){
        Ventana v1 = new Ventana();
        v1.setVisible(true);
    }
}

class Ventana extends JFrame{
    public Ventana(){
        setSize(500,500);
    }
}