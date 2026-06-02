package week13;

import javax.swing.*;

public class week13_1 {
    public static void main(String[] args) {
        // 1. 프레임 생성
        JFrame jf = new JFrame();
        jf.setSize(300, 300);
        jf.setTitle("300x300 사이즈의 프레임");
        // jf.setVisible(true);

        // 2. 컴포넌트 생성 - JButton 객체 2개 생성
        JButton jbtn1 = new JButton("확인");

        JButton jbtn2 = new JButton();
        jbtn2.setText("취소");

        // 3. 컨테이너에 컴포넌트 2개 버튼 부착(add)
        //jf.add(jbtn1);
        //jf.add(jbtn2);

        // 3.1 판넬 컨테이너 생성
        JPanel jp = new JPanel();
        jp.add(jbtn1);
        jp.add(jbtn2);

        // 3.2 프레임 컨테이너에 판넬 부착하기
        jf.add(jp);

        // 4. 컨테이너 닫기 동작 추가
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.pack();
        //jf.setEnabled(true);
    }
}