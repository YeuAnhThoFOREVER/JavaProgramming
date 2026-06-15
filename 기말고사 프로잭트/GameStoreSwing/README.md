# GameStoreSwing (게임 스토어)

Xbox / PlayStation / Nintendo Switch 게임을 판매하는 자바 Swing 데스크톱 매장 프로그램입니다.
데이터는 메모리 상에서만 관리합니다(DB/파일 미사용).
패키지명과 클래스명은 영어, 주석과 모든 UI 화면 텍스트는 한국어로 작성되어 있습니다.

## 실행 방법 (Eclipse)
1. File > New > Java Project, 이름을 `GameStoreSwing` 으로 지정합니다. "Create module-info.java" 는 체크 해제합니다.
2. `src/` 폴더를 복사해 넣습니다(또는 이 폴더를 프로젝트로 지정).
3. `com.gamestore.main.Welcome` 을 Java Application 으로 실행합니다.

> 한글이 깨져 보이면 프로젝트 인코딩을 UTF-8 로 설정하세요.
> (Window > Preferences > General > Workspace > Text file encoding > UTF-8)

## 실행 방법 (명령줄)
```
javac -encoding UTF-8 -d bin $(find src -name "*.java")
java -cp bin com.gamestore.main.Welcome
```

## 앱 흐름
CustomerWindow(고객 정보 입력) → MainWindow(9개 메뉴 버튼) → 각 기능 페이지.

## 관리자 로그인
아이디: `admin`  /  비밀번호: `1234`

- `com.gamestore.member.Admin` 의 공개 상수 `Admin.ADMIN_ID` / `Admin.ADMIN_PW` 로 정의되어 있습니다.
- 동일한 계정 정보가 로그인 창(9번 메뉴)에 표시되고 입력칸에 미리 채워져 있어, 한 번의 클릭으로 로그인할 수 있습니다.
- 관리자 화면에서는 상품 **추가 / 수정 / 삭제** 와 **재고 +1 / -1** 조정이 모두 가능합니다.

## 적용한 객체지향(OOP) 개념
- 상속(Inheritance): User/Admin 이 Person 을 상속, Game 이 Product 를 상속
- 추상 클래스(Abstract class): Product
- 인터페이스(Interface): CartInterface (Cart 가 구현)
- 커스텀 예외(Custom exception): CartException (주문 시 빈 장바구니 처리)
- 패키지(Packages): com.gamestore.{member, product, cart, exception, main, page}
- 재고(Stock): Game 에서 관리하며, ReceiptPage 주문 시 차감되고 0 이면 구매 차단

## AI 사용 명시
모든 소스 파일 최상단에 `[AI 사용 명시 주석 - AI USE COMPLIANCE STATEMENT]`
주석 블록이 있으며, AI 사용 여부 / 사용 모델 / 적용 코드 범위 / 사용 목적을 명시합니다.

## 주석
모든 코드 내 주석은 한국어로 작성되어 있습니다.

## 참고 / 간단 수정 포인트
- 카탈로그 초기 데이터: com.gamestore.product.GameInit
- 통화 단위: 원(KRW, ₩), 천 단위 구분 기호 사용
