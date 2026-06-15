package com.gamestore.member;

/**
 * =================================================================
 * [AI 사용 명시 주석 - AI USE COMPLIANCE STATEMENT]
 * -----------------------------------------------------------------
 * 1. AI 사용 여부 : YES
 * 2. 사용 AI 모델 : Anthropic Claude (Opus 4.8, 2026-06 버전)
 * 3. 적용 코드 범위 : User 클래스 - Person 을 상속한 일반 고객 클래스
 * 4. 사용 목적 및 사유 : 상속(extends) 원칙에 맞춘 고객 클래스 설계 지원.
 * =================================================================
 */

/** 매장 고객(상속 - Person 확장). */
public class User extends Person {
    public User() {
        super();
    }

    public User(String name, String phone, String address) {
        super(name, phone, address);
    }
}
