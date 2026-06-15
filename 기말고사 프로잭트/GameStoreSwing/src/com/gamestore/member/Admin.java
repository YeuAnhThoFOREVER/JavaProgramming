package com.gamestore.member;

/**
 * =================================================================
 * [AI 사용 명시 주석 - AI USE COMPLIANCE STATEMENT]
 * -----------------------------------------------------------------
 * 1. AI 사용 여부 : YES
 * 2. 사용 AI 모델 : Anthropic Claude (Opus 4.8, 2026-06 버전)
 * 3. 적용 코드 범위 : Admin 클래스 - 관리자 계정 상수 노출 및 로그인 검증 로직
 * 4. 사용 목적 및 사유 : Person 상속 구조에서 관리자 인증(아이디/비밀번호)을
 *    구현하고, 교수님 채점 편의를 위해 계정 정보를 코드에 명확히 노출.
 * =================================================================
 */

/** 로그인 정보를 가진 관리자(상속 - Person 확장). */
public class Admin extends Person {

    // =================================================================
    // [관리자 계정 정보 - 채점/시연용으로 코드에 그대로 노출함]
    //   아이디(ID)   : admin
    //   비밀번호(PW) : 1234
    // 관리자 로그인 창(9번 메뉴)에도 동일하게 화면에 표시됩니다.
    // =================================================================
    public static final String ADMIN_ID = "admin";
    public static final String ADMIN_PW = "1234";

    private final String adminId;
    private final String password;

    // 기본 관리자 계정: admin / 1234
    public Admin() {
        super("관리자", "-", "-"); // 이름: 관리자
        this.adminId = ADMIN_ID;
        this.password = ADMIN_PW;
    }

    public Admin(String adminId, String password) {
        super("관리자", "-", "-");
        this.adminId = adminId;
        this.password = password;
    }

    public String getAdminId() { return adminId; }
    public String getPassword() { return password; }

    /** 입력한 계정 정보가 일치하면 true 를 반환한다. */
    public boolean login(String adminId, String password) {
        return this.adminId.equals(adminId) && this.password.equals(password);
    }
}
