package week13;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dialog extends JFrame implements ActionListener {
    JButton button1, button2, button3, button4;
    Color color;

    Dialog() {
        setTitle("대화상자 아이콘");
        setSize(450, 250);
        setLayout(new FlowLayout());

        JPanel panel = new JPanel();
        panel.setBackground(new Color(240, 240, 240));
        add(panel);

        button1 = new JButton("ERROR");
        button2 = new JButton("INFORMATION");
        button3 = new JButton("WARNING");
        button4 = new JButton("QUESTION");

        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);

        color = button1.getBackground();

        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        initButton();

        if (obj == button1) {
            button1.setBackground(Color.CYAN);
            JOptionPane.showMessageDialog(this, "JOptionPane 대화상자",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } else if (obj == button2) {
            button2.setBackground(Color.CYAN);
            JOptionPane.showMessageDialog(this, "JOptionPane 대화상자",
                    "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
        } else if (obj == button3) {
            button3.setBackground(Color.CYAN);
            JOptionPane.showMessageDialog(this, "JOptionPane 대화상자",
                    "WARNING", JOptionPane.WARNING_MESSAGE);
        } else if (obj == button4) {
            button4.setBackground(Color.CYAN);
            JOptionPane.showMessageDialog(this, "JOptionPane 대화상자",
                    "QUESTION", JOptionPane.QUESTION_MESSAGE);
        }
    }

    public void initButton() {
        button1.setBackground(color);
        button2.setBackground(color);
        button3.setBackground(color);
        button4.setBackground(color);
    }

    public static void main(String[] args) {
        new Dialog();
    }
}