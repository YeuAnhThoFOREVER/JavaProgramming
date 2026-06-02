package week13;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ExCustomDialog extends JDialog {
    private JPanel panel1, panel2;
    private JLabel label;
    private JButton okBtn;
    private JButton cancelBtn;

    public ExCustomDialog(JFrame frame, String str) {
        super(frame, str, true);

        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        add(panel1);

        label = new JLabel("커스텀 대화상자!", JLabel.CENTER);
        panel1.add(label, BorderLayout.CENTER);

        panel2 = new JPanel();
        panel1.add(panel2, BorderLayout.SOUTH);

        okBtn = new JButton("닫기");
        okBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel2.add(okBtn);

        cancelBtn = new JButton("취소");
        cancelBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        panel2.add(cancelBtn);

        setSize(200, 150);
    }
}