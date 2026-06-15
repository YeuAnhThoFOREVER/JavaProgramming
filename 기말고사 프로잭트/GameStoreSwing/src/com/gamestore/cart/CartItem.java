package com.gamestore.cart;

import com.gamestore.product.Game;

/**
 * =================================================================
 * [AI 사용 명시 주석 - AI USE COMPLIANCE STATEMENT]
 * -----------------------------------------------------------------
 * 1. AI 사용 여부 : YES
 * 2. 사용 AI 모델 : Anthropic Claude (Opus 4.8, 2026-06 버전)
 * 3. 적용 코드 범위 : CartItem 클래스 - 장바구니 개별 항목(게임+수량) 모델
 * 4. 사용 목적 및 사유 : 은닉화 원칙에 맞춘 항목 모델 및 소계 계산 로직 설계 지원.
 * =================================================================
 */

/** 장바구니의 한 줄: 게임과 선택 수량. */
public class CartItem {
    private Game game;
    private int quantity;

    public CartItem(Game game, int quantity) {
        this.game = game;
        this.quantity = quantity;
    }

    public Game getGame() { return game; }
    public void setGame(Game game) { this.game = game; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public void increaseQuantity() { this.quantity++; }
    public void decreaseQuantity() { if (this.quantity > 0) this.quantity--; }

    public int getSubtotal() { return game.getPrice() * quantity; }
}
