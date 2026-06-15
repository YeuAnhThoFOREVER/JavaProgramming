package com.gamestore.product;

import java.util.ArrayList;
import java.util.List;

/**
 * =================================================================
 * [AI 사용 명시 주석 - AI USE COMPLIANCE STATEMENT]
 * -----------------------------------------------------------------
 * 1. AI 사용 여부 : YES
 * 2. 사용 AI 모델 : Anthropic Claude (Opus 4.8, 2026-06 버전)
 * 3. 적용 코드 범위 : GameInit 클래스 - 게임 카탈로그 초기 데이터 및
 *    관리자 상품 추가/삭제(CRUD)를 위한 동적 리스트 구조
 * 4. 사용 목적 및 사유 : 관리자 권한으로 상품을 추가/삭제할 수 있도록
 *    고정 배열을 동적 ArrayList 기반 구조로 변경하는 설계 지원.
 * =================================================================
 */

/** 메모리 상의 게임 카탈로그를 초기화하고 관리한다(파일/DB 미사용). */
public class GameInit {
    // 관리자 추가/삭제가 가능하도록 동적 리스트로 보관한다.
    private final List<Game> games = new ArrayList<>();

    public GameInit() {
        games.add(new Game("G001", "Halo Infinite",                  49000, Platform.XBOX,            "FPS",        "2021-12-08", 10));
        games.add(new Game("G002", "Forza Horizon 5",                69000, Platform.XBOX,            "Racing",     "2021-11-09",  7));
        games.add(new Game("G003", "Starfield",                      79000, Platform.XBOX,            "RPG",        "2023-09-06",  5));
        games.add(new Game("G004", "God of War Ragnarok",            74000, Platform.PLAYSTATION,     "Action",     "2022-11-09",  8));
        games.add(new Game("G005", "The Last of Us Part II",         59000, Platform.PLAYSTATION,     "Action",     "2020-06-19",  6));
        games.add(new Game("G006", "Gran Turismo 7",                 69000, Platform.PLAYSTATION,     "Racing",     "2022-03-04",  4));
        games.add(new Game("G007", "The Legend of Zelda: TOTK",      76000, Platform.NINTENDO_SWITCH, "Adventure",  "2023-05-12",  9));
        games.add(new Game("G008", "Super Mario Odyssey",            64000, Platform.NINTENDO_SWITCH, "Platformer", "2017-10-27", 12));
        games.add(new Game("G009", "Animal Crossing: New Horizons",  64000, Platform.NINTENDO_SWITCH, "Simulation", "2020-03-20",  3));
        games.add(new Game("G010", "Splatoon 3",                     64000, Platform.NINTENDO_SWITCH, "Shooter",    "2022-09-09",  0));
    }

    /** 전체 게임 목록을 배열로 반환한다(화면 출력용). */
    public Game[] getGames() {
        return games.toArray(new Game[0]);
    }

    /** ID 로 게임을 찾는다. 없으면 null. */
    public Game findById(String id) {
        for (Game g : games) {
            if (g.getId().equals(id)) {
                return g;
            }
        }
        return null;
    }

    /** [관리자] 새 상품을 카탈로그에 추가한다. */
    public void addGame(Game game) {
        games.add(game);
    }

    /** [관리자] ID 에 해당하는 상품을 삭제한다. 삭제 성공 시 true. */
    public boolean removeById(String id) {
        return games.removeIf(g -> g.getId().equals(id));
    }

    /** 동일한 ID 가 이미 존재하는지 확인한다(중복 등록 방지). */
    public boolean existsId(String id) {
        return findById(id) != null;
    }
}
