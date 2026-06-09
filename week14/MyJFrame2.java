package week14;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MyJFrame2 extends JFrame {

    public MyJFrame2() {
        this.setTitle("버튼 & 텍스트필드");
        Container con = getContentPane();
        setLayout(new FlowLayout());

        JButton btn = new JButton("소개");
        JButton btn2 = new JButton("확인");
        JTextField jf = new JTextField(20);

        con.add(btn);
        con.add(btn2);
        con.add(jf);

        // Single listener handling both buttons
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object obj = e.getSource();
                if (obj == btn) {
                    System.out.println("소개 버튼 클릭");
                } else if (obj == btn2) {
                    System.out.println("입력된 텍스트: " + jf.getText());
                    jf.setText(""); // clear after reading
                }
            }
        };

        btn.addActionListener(listener);
        btn2.addActionListener(listener);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new MyJFrame2();
    }
}