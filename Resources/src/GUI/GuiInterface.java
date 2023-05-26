package GUI;

import javax.swing.*;
import javax.swing.plaf.basic.BasicArrowButton;
import java.awt.*;

public class GuiInterface
{
    public static void main(String args[])
    {
        JFrame frame = new JFrame(); // declares new frame

        JButton button = new JButton("Click-me"); // declares new btn

        button.setBounds(
                150, 200, 220, 50 // x axis, y axis, width, height
        );

        frame.add(button);



        frame.setSize(500, 600);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}