import com.intellij.uiDesigner.lw.LwHSpacer;
import com.intellij.uiDesigner.lw.LwVSpacer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test{

    public static void main(String[] args) throws Exception {
        JFrame frame        = new JFrame("myWindow");
        JButton button      = new JButton("Please dont touch!");

        ActionListener actionListener = (ActionEvent e) -> {
            System.out.println("You touch button.");
        };

        JTextField textField = new JTextField();
        textField.setText("my text");
        textField.setBounds(50,100,200,30);

        button.addActionListener(actionListener);
        button.setBounds(50,140,85,20);

        frame.add(button);
        frame.add(textField);


        frame.pack();
        frame.setVisible(true);
        frame.setSize(300,300);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
