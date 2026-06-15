package com.gamestore.member;

/**
 * =================================================================
 * [AI 사용 명시 주석 - AI USE COMPLIANCE STATEMENT]
 * -----------------------------------------------------------------
 * 1. AI 사용 여부 : YES
 * 2. 사용 AI 모델 : Anthropic Claude (Opus 4.8, 2026-06 버전)
 * 3. 적용 코드 범위 : Person 클래스 - 회원 공통 인적정보 부모 클래스
 * 4. 사용 목적 및 사유 : 상속/은닉화 원칙에 맞춘 회원 부모 클래스 설계 지원.
 * =================================================================
 */

/** 연락처 정보를 가진 모든 사람의 부모 클래스(상속). */
public class Person {
    protected String name;
    protected String phone;
    protected String address;

    public Person() {
    }

    public Person(String name, String phone, String address) {
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
