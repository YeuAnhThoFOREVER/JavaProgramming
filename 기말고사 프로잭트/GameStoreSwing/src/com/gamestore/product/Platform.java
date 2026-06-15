package com.gamestore.product;

/**
 * =================================================================
 * [AI 사용 명시 주석 - AI USE COMPLIANCE STATEMENT]
 * -----------------------------------------------------------------
 * 1. AI 사용 여부 : YES
 * 2. 사용 AI 모델 : Anthropic Claude (Opus 4.8, 2026-06 버전)
 * 3. 적용 코드 범위 : Platform 열거형 - 콘솔 플랫폼 종류 정의
 * 4. 사용 목적 및 사유 : 게임이 속한 플랫폼을 타입 안전하게 표현하는 enum 설계 지원.
 * =================================================================
 */

/** 매장에서 판매하는 세 가지 콘솔 플랫폼. */
public enum Platform {
    XBOX("Xbox"),
    PLAYSTATION("PlayStation"),
    NINTENDO_SWITCH("Nintendo Switch");

    private final String label;

    Platform(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
