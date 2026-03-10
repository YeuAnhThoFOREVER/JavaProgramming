package day02;

public class DataTypeTest {

    public static void main(String[] args) {
        // 1. 기본형 변수 선언
        boolean isTrue;
        int age;
        double height, weight;

        // 2. 변수 초기화
        isTrue = false;
        age = 20;
        height = 180.5;
        weight = 90.12;

        // 2. 레퍼런스형 - 3개(배열, 클래스, 인터페이스)
        String name = "응엔 꽤 비엔";           // ✅ Fixed: String (capital S)
        String s = new String("응엔 꽤 비엔");  // ✅ Fixed: proper syntax

        DataTypeTest ddt = new DataTypeTest();
        //주소 addr
        String addr = "동구 용운동";

        // 3. 변수 값 출력하기
        	System.out.println("주소: "+addr);
        System.out.println(isTrue);
        System.out.println("나이:"+age);
        System.out.println("키:"+height+" cm");
        System.out.println("무게:"+weight+" kg");
        System.out.println("이름:"+name);
    }
}