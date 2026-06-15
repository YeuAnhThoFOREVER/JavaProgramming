package com.gamestore.main;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

import com.gamestore.cart.Cart;
import com.gamestore.member.User;
import com.gamestore.member.UserInit;
import com.gamestore.product.GameInit;

/**
 * =================================================================
 * [AI 사용 명시 주석 - AI USE COMPLIANCE STATEMENT]
 * -----------------------------------------------------------------
 * 1. AI 사용 여부 : YES
 * 2. 사용 AI 모델 : Anthropic Claude (Opus 4.8, 2026-06 버전)
 * 3. 적용 코드 범위 : CustomerWindow 클래스 - 최초 고객 정보 입력 화면
 * 4. 사용 목적 및 사유 : 입력값 검증과 세션 생성 후 메인 메뉴로 전환하는 흐름 설계 지원.
 * =================================================================
 */

/** 첫 화면: 고객의 연락처 정보를 입력받는다. */
public class CustomerWindow extends JFrame {
    private static final long serialVersionUID = 1L;

    private final JTextField nameField = new JTextField();
    private final JTextField phoneField = new JTextField();
    private final JTextField addressField = new JTextField();

    public CustomerWindow() {
        setTitle("게임 스토어 - 고객 정보 입력");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));

        JPanel form = new JPanel(new GridLayout(3, 2, 8, 8));
        form.add(new JLabel("이름:"));
        form.add(nameField);
        form.add(new JLabel("연락처:"));
        form.add(phoneField);
        form.add(new JLabel("주소:"));
        form.add(addressField);

        JButton confirmButton = new JButton("입력 완료");
        confirmButton.addActionListener(e -> onConfirm());

        add(new JLabel("  고객 정보를 입력해 주세요."), BorderLayout.NORTH);
        add(form, BorderLayout.CENTER);
        add(confirmButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void onConfirm() {
        String name = nameField.getText().trim();
        String phone = phoneField.getText().trim();
        String address = addressField.getText().trim();

        if (name.isEmpty() || phone.isEmpty() || address.isEmpty()) {
            JOptionPane.showMessageDialog(this, "모든 정보를 입력해 주세요.",
                    "경고", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 세션 상태를 만들고 메인 메뉴로 이동한다.
        User user = new User(name, phone, address);
        UserInit userInit = new UserInit();
        userInit.setCurrentUser(user);

        Cart cart = new Cart();
        GameInit gameInit = new GameInit();

        new MainWindow(userInit, cart, gameInit);
        dispose();
    }
}
