package com.gamestore.main;

import javax.swing.SwingUtilities;

/**
 * =================================================================
 * [AI 사용 명시 주석 - AI USE COMPLIANCE STATEMENT]
 * -----------------------------------------------------------------
 * 1. AI 사용 여부 : YES
 * 2. 사용 AI 모델 : Anthropic Claude (Opus 4.8, 2026-06 버전)
 * 3. 적용 코드 범위 : Welcome 클래스 - 애플리케이션 진입점(main)
 * 4. 사용 목적 및 사유 : Swing 이벤트 디스패치 스레드에서 앱을 시작하는 구조 설계 지원.
 * =================================================================
 */

/** 애플리케이션 진입점. */
public class Welcome {
    public static void main(String[] args) {
        // 고객 정보 입력 창을 Swing 이벤트 디스패치 스레드에서 실행한다.
        SwingUtilities.invokeLater(CustomerWindow::new);
    }
}
