package week13;
import javax.swing.*;

public class ExMenu01 extends JFrame {
    public ExMenu01() {
        setTitle("메뉴 만들기");
        setSize(400, 200);

        JMenuBar menuBar = new JMenuBar();

        JMenu menu01 = new JMenu("File");
        JMenu menu02 = new JMenu("Edit");
        JMenu menu03 = new JMenu("Help");

        menuBar.add(menu01);
        menuBar.add(menu02);
        menuBar.add(menu03);

        JMenuItem item01 = new JMenuItem("New");
        JMenuItem item02 = new JMenuItem("Open");

        menu01.add(item01);
        menu01.add(item02);

        setJMenuBar(menuBar);
        setLayout(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ExMenu01();
    }
}