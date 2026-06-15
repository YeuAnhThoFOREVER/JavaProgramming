package com.gamestore.page;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.gamestore.cart.Cart;
import com.gamestore.product.Game;
import com.gamestore.product.GameInit;

/**
 * =================================================================
 * [AI 사용 명시 주석 - AI USE COMPLIANCE STATEMENT]
 * -----------------------------------------------------------------
 * 1. AI 사용 여부 : YES
 * 2. 사용 AI 모델 : Anthropic Claude (Opus 4.8, 2026-06 버전)
 * 3. 적용 코드 범위 : AddToCartPage 클래스 - 상품 카탈로그 표시 및 장바구니 담기
 * 4. 사용 목적 및 사유 : 카탈로그 표 출력, 선택 검증, 중복 시 수량 증가 로직 설계 지원.
 * =================================================================
 */

/** [4] 카탈로그를 보여주고 고객이 게임을 장바구니에 담게 한다. */
public class AddToCartPage extends JDialog {
    private static final long serialVersionUID = 1L;

    private final Cart cart;
    private final GameInit gameInit;
    private final JTable table;

    public AddToCartPage(Frame owner, Cart cart, GameInit gameInit) {
        super(owner, "장바구니에 담기", true);
        this.cart = cart;
        this.gameInit = gameInit;

        setSize(760, 360);
        setLocationRelativeTo(owner);
        setLayout(new BorderLayout(10, 10));

        String[] columns = {"ID", "제목", "플랫폼", "장르", "가격", "출시일", "재고"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            private static final long serialVersionUID = 1L;
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for (Game g : gameInit.getGames()) {
            model.addRow(new Object[] {
                g.getId(),
                g.getTitle(),
                g.getPlatform().getLabel(),
                g.getGenre(),
                String.format("₩%,d", g.getPrice()),
                g.getReleaseDate(),
                g.getStock()
            });
        }

        table = new JTable(model);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        JButton addButton = new JButton("장바구니에 담기");
        addButton.addActionListener(e -> onAdd());

        add(new JScrollPane(table), BorderLayout.CENTER);
        add(addButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void onAdd() {
        int row = table.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "게임을 선택해 주세요.",
                    "경고", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String id = (String) table.getValueAt(row, 0);
        Game game = gameInit.findById(id);
        if (game == null) {
            return;
        }

        if (game.isSoldOut()) {
            JOptionPane.showMessageDialog(this, "품절된 상품입니다.",
                    "알림", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // 이미 장바구니에 있으면 isCartInGame 이 수량을 증가시킨다.
        if (!cart.isCartInGame(id)) {
            cart.insertGame(game);
        }
        JOptionPane.showMessageDialog(this, "장바구니에 담았습니다.",
                "알림", JOptionPane.INFORMATION_MESSAGE);
    }
}
