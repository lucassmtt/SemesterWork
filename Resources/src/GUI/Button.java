package GUI;

import java.awt.*;


class button {

    public static void main(String args[]){
        new button();
    }

    button(){
        Frame frame = new Frame("My Mini APP");
        Button btn_01 = new Button("OK");
        btn_01.setBounds(100, 50, 50, 50);
        frame.add(btn_01);

        Button btn_02 = new Button("Submit");
        btn_02.setBounds(100, 101, 50, 50);
        frame.add(btn_02);

        Button btn_03 = new Button("Cancel");
        btn_03.setBounds(100, 150, 80, 50);
        frame.add(btn_03);

        frame.setSize(500, 500);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}
