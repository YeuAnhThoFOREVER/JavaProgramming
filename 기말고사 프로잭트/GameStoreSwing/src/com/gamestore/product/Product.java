package com.gamestore.product;

/**
 * =================================================================
 * [AI 사용 명시 주석 - AI USE COMPLIANCE STATEMENT]
 * -----------------------------------------------------------------
 * 1. AI 사용 여부 : YES
 * 2. 사용 AI 모델 : Anthropic Claude (Opus 4.8, 2026-06 버전)
 * 3. 적용 코드 범위 : Product 추상 클래스 - 상품 공통 속성 및 추상 메서드 정의
 * 4. 사용 목적 및 사유 : 추상화/은닉화 원칙에 맞춘 상품 부모 클래스 설계 지원.
 * =================================================================
 */

/** 매장에서 판매하는 모든 상품의 추상 부모 타입(추상화). */
public abstract class Product {
    protected String id;
    protected String title;
    protected int price; // 단위: 원(KRW)

    public Product() {
    }

    public Product(String id, String title, int price) {
        this.id = id;
        this.title = title;
        this.price = price;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getPrice() { return price; }
    public void setPrice(int price) { this.price = price; }

    /** 각 상품 타입이 자신의 한 줄 요약을 만들어 반환한다(추상 메서드). */
    public abstract String getSummary();
}
