package week13;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ExCustomDialog02 {
    private ExCustomDialog examDialog;

    ExCustomDialog02() {
        JFrame frame = new JFrame();
        frame.setTitle("커스텀대화상자 JDialog");
        frame.setSize(400, 200);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(240, 240, 240));
        frame.add(panel);

        JButton obj1 = new JButton("불러오기");
        JButton obj2 = new JButton("종료하기");
        panel.add(obj1);
        panel.add(obj2);

        obj1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (examDialog == null) {
                    examDialog = new ExCustomDialog(frame, "대화상자");
                }
                examDialog.setVisible(true);
                obj1.requestFocus();
            }
        });

        obj2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ExCustomDialog02();
    }
}