package JForm;

import javax.swing.*;
import java.awt.*;

public class myTestForm {

    private JPanel panelMain;
    private JButton button_1;

    public myTestForm() {

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("myApplication");
        frame.setContentPane(new myTestForm().panelMain);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
