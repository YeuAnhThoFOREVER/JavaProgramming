package com.gamestore.page;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.*;

import com.gamestore.member.Admin;
import com.gamestore.product.GameInit;

/**
 * =================================================================
 * [AI 사용 명시 주석 - AI USE COMPLIANCE STATEMENT]
 * -----------------------------------------------------------------
 * 1. AI 사용 여부 : YES
 * 2. 사용 AI 모델 : Anthropic Claude (Opus 4.8, 2026-06 버전)
 * 3. 적용 코드 범위 : AdminLoginDialog 클래스 - 관리자 로그인 대화상자 및
 *    채점 편의용 계정 정보 화면 표시/자동 입력
 * 4. 사용 목적 및 사유 : 관리자 인증 흐름과, 교수님이 빠르게 로그인하여
 *    확인할 수 있도록 계정 정보를 화면에 노출하고 자동 입력하는 기능 작성 지원.
 * =================================================================
 */

/** [9] 관리자 로그인. 성공 시 AdminPage 를 연다. */
public class AdminLoginDialog extends JDialog {
    private static final long serialVersionUID = 1L;

    private final Frame owner;
    private final GameInit gameInit;
    private final Admin admin = new Admin(); // 기본 관리자 admin / 1234

    // 채점/시연 편의를 위해 계정 정보를 미리 채워 둔다.
    private final JTextField idField = new JTextField(Admin.ADMIN_ID);
    private final JPasswordField passwordField = new JPasswordField(Admin.ADMIN_PW);

    public AdminLoginDialog(Frame owner, GameInit gameInit) {
        super(owner, "관리자 로그인", true);
        this.owner = owner;
        this.gameInit = gameInit;

        setSize(360, 220);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout(10, 10));

        JPanel form = new JPanel(new GridLayout(2, 2, 8, 8));
        form.add(new JLabel("아이디:"));
        form.add(idField);
        form.add(new JLabel("비밀번호:"));
        form.add(passwordField);

        // 화면에 계정 정보를 그대로 노출(교수님 빠른 확인용)
        JLabel hint = new JLabel(
                "<html>관리자 계정 → 아이디: <b>" + Admin.ADMIN_ID
                + "</b> / 비밀번호: <b>" + Admin.ADMIN_PW + "</b></html>");
        hint.setForeground(new Color(0, 102, 204));

        JPanel north = new JPanel(new GridLayout(2, 1));
        north.add(new JLabel("  관리자 계정으로 로그인하세요."));
        north.add(hint);

        JButton loginButton = new JButton("로그인");
        loginButton.addActionListener(e -> onLogin());

        add(north, BorderLayout.NORTH);
        add(form, BorderLayout.CENTER);
        add(loginButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void onLogin() {
        String id = idField.getText().trim();
        String password = new String(passwordField.getPassword());

        if (admin.login(id, password)) {
            new AdminPage(owner, gameInit);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "아이디 또는 비밀번호가 올바르지 않습니다.",
                    "로그인 실패", JOptionPane.ERROR_MESSAGE);
        }
    }
}
