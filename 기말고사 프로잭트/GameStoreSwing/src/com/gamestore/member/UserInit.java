package com.gamestore.member;

/**
 * =================================================================
 * [AI 사용 명시 주석 - AI USE COMPLIANCE STATEMENT]
 * -----------------------------------------------------------------
 * 1. AI 사용 여부 : YES
 * 2. 사용 AI 모델 : Anthropic Claude (Opus 4.8, 2026-06 버전)
 * 3. 적용 코드 범위 : UserInit 클래스 - 현재 세션 고객 정보 보관
 * 4. 사용 목적 및 사유 : 실행 중 현재 고객 세션 상태 관리 구조 설계 지원.
 * =================================================================
 */

/** 실행 중인 세션의 현재 고객을 메모리에 보관한다. */
public class UserInit {
    private User currentUser;

    public User getCurrentUser() { return currentUser; }
    public void setCurrentUser(User currentUser) { this.currentUser = currentUser; }
}
