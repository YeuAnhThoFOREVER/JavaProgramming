package com.gamestore.cart;

import java.util.ArrayList;
import java.util.List;

import com.gamestore.product.Game;

/**
 * =================================================================
 * [AI 사용 명시 주석 - AI USE COMPLIANCE STATEMENT]
 * -----------------------------------------------------------------
 * 1. AI 사용 여부 : YES
 * 2. 사용 AI 모델 : Anthropic Claude (Opus 4.8, 2026-06 버전)
 * 3. 적용 코드 범위 : Cart 클래스 - CartInterface 구현 및 장바구니 비즈니스 로직
 * 4. 사용 목적 및 사유 : 다형성(인터페이스 구현)과 수량 증감/합계 계산 로직 설계 지원.
 * =================================================================
 */

/** 메모리 기반 장바구니(CartInterface 구현 - 다형성). */
public class Cart implements CartInterface {

    private final List<CartItem> items = new ArrayList<>();

    @Override
    public void printGameList(Game[] games) {
        for (Game g : games) {
            System.out.println(g.getSummary());
        }
    }

    @Override
    public boolean isCartInGame(String id) {
        for (CartItem item : items) {
            if (item.getGame().getId().equals(id)) {
                item.increaseQuantity();
                return true;
            }
        }
        return false;
    }

    @Override
    public void insertGame(Game game) {
        items.add(new CartItem(game, 1));
    }

    @Override
    public void removeCart(int index) {
        if (index >= 0 && index < items.size()) {
            items.remove(index);
        }
    }

    @Override
    public void clearCart() {
        items.clear();
    }

    public List<CartItem> getItems() { return items; }

    public boolean isEmpty() { return items.isEmpty(); }

    public int getItemCount() { return items.size(); }

    public int getTotalPrice() {
        int total = 0;
        for (CartItem item : items) {
            total += item.getSubtotal();
        }
        return total;
    }

    /** 항목 수량을 줄인다. 0 이 되면 항목을 삭제한다. */
    public void reduceQuantity(int index) {
        if (index >= 0 && index < items.size()) {
            CartItem item = items.get(index);
            item.decreaseQuantity();
            if (item.getQuantity() <= 0) {
                items.remove(index);
            }
        }
    }
}
