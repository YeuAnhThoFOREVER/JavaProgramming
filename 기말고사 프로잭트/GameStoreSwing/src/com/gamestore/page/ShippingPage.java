package com.gamestore.page;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.*;

import com.gamestore.cart.Cart;
import com.gamestore.exception.CartException;
import com.gamestore.member.User;
import com.gamestore.member.UserInit;

/**
 * =================================================================
 * [AI 사용 명시 주석 - AI USE COMPLIANCE STATEMENT]
 * -----------------------------------------------------------------
 * 1. AI 사용 여부 : YES
 * 2. 사용 AI 모델 : Anthropic Claude (Opus 4.8, 2026-06 버전)
 * 3. 적용 코드 범위 : ShippingPage 클래스 - 배송지 입력 및 빈 장바구니 예외 처리
 * 4. 사용 목적 및 사유 : 주문 전 배송지 확인과 CartException 예외 전파/처리 로직 설계 지원.
 * =================================================================
 */

/** [7] 배송지 정보 입력 후 영수증으로 진행한다. */
public class ShippingPage extends JDialog {
    private static final long serialVersionUID = 1L;

    private final Frame owner;
    private final UserInit userInit;
    private final Cart cart;

    private final JTextField nameField;
    private final JTextField phoneField;
    private final JTextField addressField;

    public ShippingPage(Frame owner, UserInit userInit, Cart cart) {
        super(owner, "주문하기 - 배송지 입력", true);
        this.owner = owner;
        this.userInit = userInit;
        this.cart = cart;

        setSize(400, 260);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout(10, 10));

        User user = userInit.getCurrentUser();
        nameField = new JTextField(user.getName());
        phoneField = new JTextField(user.getPhone());
        addressField = new JTextField(user.getAddress());

        JPanel form = new JPanel(new GridLayout(3, 2, 8, 8));
        form.add(new JLabel("받는 사람:"));
        form.add(nameField);
        form.add(new JLabel("연락처:"));
        form.add(phoneField);
        form.add(new JLabel("배송지:"));
        form.add(addressField);

        JButton orderButton = new JButton("주문 완료");
        orderButton.addActionListener(e -> onOrder());

        add(new JLabel("  배송지 정보를 확인해 주세요."), BorderLayout.NORTH);
        add(form, BorderLayout.CENTER);
        add(orderButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void onOrder() {
        try {
            if (cart.isEmpty()) {
                throw new CartException("장바구니가 비어 있습니다.");
            }
            // 고객의 배송 정보를 갱신한다.
            User user = userInit.getCurrentUser();
            user.setName(nameField.getText().trim());
            user.setPhone(phoneField.getText().trim());
            user.setAddress(addressField.getText().trim());

            // 영수증을 표시한다. 영수증에서 주문을 확정하고 재고를 차감한다.
            new ReceiptPage(owner, user, cart);
            dispose();
        } catch (CartException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "주문 오류", JOptionPane.ERROR_MESSAGE);
        }
    }
}
