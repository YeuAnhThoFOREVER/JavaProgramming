package com.gamestore.cart;

import com.gamestore.product.Game;

/**
 * =================================================================
 * [AI 사용 명시 주석 - AI USE COMPLIANCE STATEMENT]
 * -----------------------------------------------------------------
 * 1. AI 사용 여부 : YES
 * 2. 사용 AI 모델 : Anthropic Claude (Opus 4.8, 2026-06 버전)
 * 3. 적용 코드 범위 : CartInterface 인터페이스 - 장바구니 핵심 동작 명세
 * 4. 사용 목적 및 사유 : 다형성 원칙에 맞춘 장바구니 행위 인터페이스 설계 지원.
 * =================================================================
 */

/** 장바구니 동작 규약(다형성). */
public interface CartInterface {

    /** 전체 게임 목록을 출력한다(콘솔 보조용). */
    void printGameList(Game[] games);

    /**
     * 이미 장바구니에 있는 게임이면 수량을 1 증가시키고 true 를 반환한다.
     * 그렇지 않으면 false 를 반환한다.
     */
    boolean isCartInGame(String id);

    /** 새 게임 항목을 장바구니에 추가한다. */
    void insertGame(Game game);

    /** 지정한 인덱스의 장바구니 항목을 삭제한다. */
    void removeCart(int index);

    /** 장바구니의 모든 항목을 비운다. */
    void clearCart();
}
