package com.gamestore.exception;

/**
 * =================================================================
 * [AI 사용 명시 주석 - AI USE COMPLIANCE STATEMENT]
 * -----------------------------------------------------------------
 * 1. AI 사용 여부 : YES
 * 2. 사용 AI 모델 : Anthropic Claude (Opus 4.8, 2026-06 버전)
 * 3. 적용 코드 범위 : CartException 커스텀 예외 처리 구현부 전체 및
 *    주문 시 빈 장바구니 예외 전파(try-catch) 로직 구조
 * 4. 사용 목적 및 사유 : 자바 Swing 환경에서 런타임 예외로 인한 시스템 다운을
 *    예방하기 위한 커스텀 예외 전파 아키텍처 뼈대 설계 도움.
 * =================================================================
 */

/** 장바구니 관련 문제(빈 장바구니, 품절 등)에 대한 커스텀 예외. */
public class CartException extends Exception {
    private static final long serialVersionUID = 1L;

    public CartException(String message) {
        super(message);
    }
}
