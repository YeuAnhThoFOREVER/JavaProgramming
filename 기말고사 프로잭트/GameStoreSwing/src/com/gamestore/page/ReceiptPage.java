package com.gamestore.page;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.*;

import com.gamestore.cart.Cart;
import com.gamestore.cart.CartItem;
import com.gamestore.member.User;

/**
 * =================================================================
 * [AI 사용 명시 주석 - AI USE COMPLIANCE STATEMENT]
 * -----------------------------------------------------------------
 * 1. AI 사용 여부 : YES
 * 2. 사용 AI 모델 : Anthropic Claude (Opus 4.8, 2026-06 버전)
 * 3. 적용 코드 범위 : ReceiptPage 클래스 - 주문 영수증 출력, 재고 차감, 장바구니 비우기
 * 4. 사용 목적 및 사유 : 한국어 영수증 구성과 주문 확정 시 재고 차감 로직 설계 지원.
 * =================================================================
 */

/** [7] 최종 영수증. 재고를 차감하고 장바구니를 비운다. */
public class ReceiptPage extends JDialog {
    private static final long serialVersionUID = 1L;

    public ReceiptPage(Frame owner, User user, Cart cart) {
        super(owner, "주문 영수증", true);
        setSize(480, 420);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout(10, 10));

        StringBuilder sb = new StringBuilder();
        sb.append("===== 주문 영수증 =====\n\n");
        sb.append("받는 사람: ").append(user.getName()).append("\n");
        sb.append("연락처: ").append(user.getPhone()).append("\n");
        sb.append("배송지: ").append(user.getAddress()).append("\n");
        sb.append("------------------------\n");

        for (CartItem item : cart.getItems()) {
            sb.append(String.format("%s [%s] x%d = ₩%,d%n",
                    item.getGame().getTitle(),
                    item.getGame().getPlatform().getLabel(),
                    item.getQuantity(),
                    item.getSubtotal()));
            // 주문이 확정되면 재고를 차감한다.
            item.getGame().reduceStock(item.getQuantity());
        }

        sb.append("------------------------\n");
        sb.append(String.format("총 결제 금액: ₩%,d%n", cart.getTotalPrice()));
        sb.append("\n주문해 주셔서 감사합니다.");

        JTextArea area = new JTextArea(sb.toString());
        area.setEditable(false);

        JButton close = new JButton("닫기");
        close.addActionListener(e -> dispose());

        add(new JScrollPane(area), BorderLayout.CENTER);
        add(close, BorderLayout.SOUTH);

        // 주문 완료: 장바구니를 비운다.
        cart.clearCart();

        setVisible(true);
    }
}
