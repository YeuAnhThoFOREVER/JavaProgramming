package week14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJFrame extends JFrame {

    public MyJFrame() {
        this.setTitle("나만의 프레임");
        Container con = getContentPane();
        setLayout(new FlowLayout());

        JButton btn = new JButton("소개");
        JButton btn2 = new JButton("확인");
        JTextField jf = new JTextField(20);

        con.add(btn);
        con.add(btn2);
        con.add(jf);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object obj = e.getSource();
                if (obj == btn) System.out.println("소개 버튼 클릭");
            }
        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(jf.getText());
            }
        });

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyJFrame();
    }
}