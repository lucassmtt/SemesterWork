package GUI;

import java.awt.*;


class CheckBox{
    CheckBox(){
        Frame frame = new Frame();

        Label label = new Label("Select know languages");

        label.setBounds(100, 50, 120, 80);
        frame.add(label);

        Checkbox checkbox_01 = new Checkbox("Portuguese");
        Checkbox checkbox_02 = new Checkbox("English");
        Checkbox checkbox_03 = new Checkbox("Spanish");

        checkbox_01.setBounds(100, 150, 50, 50);
        checkbox_02.setBounds(100, 200, 80, 50);
        checkbox_03.setBounds(100, 250, 80, 50);

        frame.add(checkbox_01);
        frame.add(checkbox_02);
        frame.add(checkbox_03);

        frame.setSize(600, 600);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public static void main(String args[]){
        System.out.println("New object!!");
        CheckBox checkbox = new CheckBox();
    }
}