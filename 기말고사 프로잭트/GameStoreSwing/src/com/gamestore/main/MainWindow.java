package com.gamestore.main;

import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.*;

import com.gamestore.cart.Cart;
import com.gamestore.member.UserInit;
import com.gamestore.page.*;
import com.gamestore.product.GameInit;

/**
 * =================================================================
 * [AI 사용 명시 주석 - AI USE COMPLIANCE STATEMENT]
 * -----------------------------------------------------------------
 * 1. AI 사용 여부 : YES
 * 2. 사용 AI 모델 : Anthropic Claude (Opus 4.8, 2026-06 버전)
 * 3. 적용 코드 범위 : MainWindow 클래스 - 메인 메뉴(9개 기능 버튼) 화면
 * 4. 사용 목적 및 사유 : 각 메뉴 버튼과 해당 페이지 연결 및 화면 전환 로직 설계 지원.
 * =================================================================
 */

/** 메인 메뉴: 매장의 9가지 기능. */
public class MainWindow extends JFrame {
    private static final long serialVersionUID = 1L;

    private final UserInit userInit;
    private final Cart cart;
    private final GameInit gameInit;

    public MainWindow(UserInit userInit, Cart cart, GameInit gameInit) {
        this.userInit = userInit;
        this.cart = cart;
        this.gameInit = gameInit;

        setTitle("게임 스토어 - 메인 메뉴");
        setSize(420, 440);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        buildMenuBar();
        buildButtons();

        setVisible(true);
    }

    private void buildMenuBar() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("메뉴");

        JMenuItem infoItem = new JMenuItem("고객 정보");
        infoItem.addActionListener(e -> openCustomerInfo());

        JMenuItem listItem = new JMenuItem("장바구니 목록");
        listItem.addActionListener(e -> openCartList());

        JMenuItem exitItem = new JMenuItem("종료");
        exitItem.addActionListener(e -> System.exit(0));

        menu.add(infoItem);
        menu.add(listItem);
        menu.addSeparator();
        menu.add(exitItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void buildButtons() {
        JPanel panel = new JPanel(new GridLayout(9, 1, 6, 6));
        panel.add(makeButton("1. 고객 정보 확인",       e -> openCustomerInfo()));
        panel.add(makeButton("2. 장바구니 목록 보기",    e -> openCartList()));
        panel.add(makeButton("3. 장바구니 비우기",       e -> clearCart()));
        panel.add(makeButton("4. 장바구니에 담기",       e -> openAddToCart()));
        // 5번/6번: 장바구니 목록 화면에서 '수량 줄이기'/'항목 삭제' 버튼으로 처리(FR-03)
        panel.add(makeButton("5. 수량 줄이기",           e -> openCartList()));
        panel.add(makeButton("6. 항목 삭제",             e -> openCartList()));
        panel.add(makeButton("7. 주문하기",              e -> openShipping()));
        panel.add(makeButton("8. 종료",                  e -> System.exit(0)));
        panel.add(makeButton("9. 관리자",                e -> openAdminLogin()));
        add(panel);
    }

    private JButton makeButton(String text, ActionListener listener) {
        JButton button = new JButton(text);
        button.addActionListener(listener);
        return button;
    }

    private void openCustomerInfo() {
        new CustomerInfoPage(this, userInit);
    }

    private void openCartList() {
        new CartListPage(this, cart);
    }

    private void clearCart() {
        cart.clearCart();
        JOptionPane.showMessageDialog(this, "장바구니를 비웠습니다.",
                "알림", JOptionPane.INFORMATION_MESSAGE);
    }

    private void openAddToCart() {
        new AddToCartPage(this, cart, gameInit);
    }

    private void openShipping() {
        new ShippingPage(this, userInit, cart);
    }

    private void openAdminLogin() {
        new AdminLoginDialog(this, gameInit);
    }
}
