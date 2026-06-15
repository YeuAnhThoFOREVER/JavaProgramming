package com.gamestore.page;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.*;

import com.gamestore.member.User;
import com.gamestore.member.UserInit;

/**
 * =================================================================
 * [AI 사용 명시 주석 - AI USE COMPLIANCE STATEMENT]
 * -----------------------------------------------------------------
 * 1. AI 사용 여부 : YES
 * 2. 사용 AI 모델 : Anthropic Claude (Opus 4.8, 2026-06 버전)
 * 3. 적용 코드 범위 : CustomerInfoPage 클래스 - 현재 고객 정보 확인 화면
 * 4. 사용 목적 및 사유 : 세션 고객의 이름/연락처/주소를 화면에 출력하는 구조 설계 지원.
 * =================================================================
 */

/** [1] 현재 고객의 정보를 보여준다. */
public class CustomerInfoPage extends JDialog {
    private static final long serialVersionUID = 1L;

    public CustomerInfoPage(Frame owner, UserInit userInit) {
        super(owner, "고객 정보 확인", true);
        setSize(350, 200);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout(10, 10));

        User user = userInit.getCurrentUser();

        JPanel panel = new JPanel(new GridLayout(3, 2, 8, 8));
        panel.add(new JLabel("이름:"));
        panel.add(new JLabel(user.getName()));
        panel.add(new JLabel("연락처:"));
        panel.add(new JLabel(user.getPhone()));
        panel.add(new JLabel("주소:"));
        panel.add(new JLabel(user.getAddress()));

        JButton close = new JButton("닫기");
        close.addActionListener(e -> dispose());

        add(new JLabel("  현재 고객 정보입니다."), BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(close, BorderLayout.SOUTH);

        setVisible(true);
    }
}
