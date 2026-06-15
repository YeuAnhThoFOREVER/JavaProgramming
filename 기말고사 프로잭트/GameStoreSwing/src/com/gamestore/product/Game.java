package com.gamestore.product;

/**
 * =================================================================
 * [AI 사용 명시 주석 - AI USE COMPLIANCE STATEMENT]
 * -----------------------------------------------------------------
 * 1. AI 사용 여부 : YES
 * 2. 사용 AI 모델 : Anthropic Claude (Opus 4.8, 2026-06 버전)
 * 3. 적용 코드 범위 : Game 클래스 - Product 를 상속한 게임 상품 모델
 * 4. 사용 목적 및 사유 : 상속/은닉화 원칙에 맞춘 게임 세부 속성 및
 *    재고 처리 로직 설계 지원.
 * =================================================================
 */

/** 특정 콘솔 플랫폼용 게임 상품(상속 - Product 확장). */
public class Game extends Product {
    private Platform platform;
    private String genre;
    private String releaseDate; // yyyy-MM-dd
    private int stock;

    public Game() {
        super();
    }

    public Game(String id, String title, int price,
                Platform platform, String genre, String releaseDate, int stock) {
        super(id, title, price);
        this.platform = platform;
        this.genre = genre;
        this.releaseDate = releaseDate;
        this.stock = stock;
    }

    public Platform getPlatform() { return platform; }
    public void setPlatform(Platform platform) { this.platform = platform; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public String getReleaseDate() { return releaseDate; }
    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }

    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }

    public boolean isSoldOut() { return stock <= 0; }

    /** 주문이 완료되면 재고를 차감한다. */
    public void reduceStock(int quantity) {
        this.stock = Math.max(0, this.stock - quantity);
    }

    @Override
    public String getSummary() {
        // 사용자에게 보여줄 한국어 요약 한 줄.
        return String.format("[%s] %s (%s) - ₩%,d",
                platform.getLabel(), title, genre, price);
    }
}
