import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        Methods methods = new Methods();
        methods.initUI();
        methods.setSize(950,600);
        methods.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        methods.setLocationRelativeTo(null);
        methods.setVisible(true);
    }
}
