package com.gamestore.page;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.gamestore.cart.Cart;
import com.gamestore.cart.CartItem;

/**
 * =================================================================
 * [AI 사용 명시 주석 - AI USE COMPLIANCE STATEMENT]
 * -----------------------------------------------------------------
 * 1. AI 사용 여부 : YES
 * 2. 사용 AI 모델 : Anthropic Claude (Opus 4.8, 2026-06 버전)
 * 3. 적용 코드 범위 : CartListPage 클래스 - 장바구니 목록/비우기/수량 줄이기/삭제(FR-03)
 * 4. 사용 목적 및 사유 : 장바구니 표 출력과 비우기/수량 감소/항목 삭제 동작 설계 지원.
 * =================================================================
 */

/** [2][3][5][6] 장바구니 내용과 비우기/수량 줄이기/삭제 기능. */
public class CartListPage extends JDialog {
    private static final long serialVersionUID = 1L;

    private final Cart cart;
    private final DefaultTableModel model;
    private final JTable table;
    private final JLabel totalLabel = new JLabel();

    public CartListPage(Frame owner, Cart cart) {
        super(owner, "장바구니 목록", true);
        this.cart = cart;

        setSize(640, 360);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout(10, 10));

        String[] columns = {"제목", "플랫폼", "단가", "수량", "금액"};
        model = new DefaultTableModel(columns, 0) {
            private static final long serialVersionUID = 1L;
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JPanel buttons = new JPanel(new GridLayout(1, 3, 6, 6));
        JButton clearButton = new JButton("장바구니 비우기");
        clearButton.addActionListener(e -> { cart.clearCart(); refresh(); });
        JButton reduceButton = new JButton("수량 줄이기");
        reduceButton.addActionListener(e -> onReduce());
        JButton deleteButton = new JButton("항목 삭제");
        deleteButton.addActionListener(e -> onDelete());
        buttons.add(clearButton);
        buttons.add(reduceButton);
        buttons.add(deleteButton);

        JPanel south = new JPanel(new BorderLayout());
        south.add(totalLabel, BorderLayout.WEST);
        south.add(buttons, BorderLayout.EAST);

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(south, BorderLayout.SOUTH);

        refresh();
        setVisible(true);
    }

    /** 장바구니 내용으로 표와 합계를 다시 그린다. */
    private void refresh() {
        model.setRowCount(0);
        for (CartItem item : cart.getItems()) {
            model.addRow(new Object[] {
                item.getGame().getTitle(),
                item.getGame().getPlatform().getLabel(),
                String.format("₩%,d", item.getGame().getPrice()),
                item.getQuantity(),
                String.format("₩%,d", item.getSubtotal())
            });
        }
        totalLabel.setText("  합계: ₩" + String.format("%,d", cart.getTotalPrice()) + "  ");
    }

    private void onReduce() {
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "항목을 선택해 주세요.",
                    "경고", JOptionPane.WARNING_MESSAGE);
            return;
        }
        cart.reduceQuantity(row);
        refresh();
    }

    private void onDelete() {
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "항목을 선택해 주세요.",
                    "경고", JOptionPane.WARNING_MESSAGE);
            return;
        }
        cart.removeCart(row);
        refresh();
    }
}
