public class Person {

    public String name;
    public int age;
    public char abc;

    public Person() {
        name = "홍길동";
        age = 20;
        abc = 'A';
        System.out.println("객체가 생성됨.");
    }

    public void 밥먹기() {
        System.out.println("밥먹다.");
    }

    public void 운동하기(String s) {  // fixed typo
        System.out.println(s + "종목을 운동합니다.");
    }
}