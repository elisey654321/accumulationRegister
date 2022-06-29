import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test{

    public static void main(String[] args) {
        JFrame frame        = new JFrame("myWindow");
        Container container = new Container();
        JButton button      = new JButton("Please dont touch!");

        ActionListener actionListener = (ActionEvent e) -> {
            System.out.println("You touch button.");
        };

        button.addActionListener(actionListener);

        frame.add(button);

        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
