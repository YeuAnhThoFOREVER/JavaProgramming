package day09;

public class week82 {
    // 작성자 이름
    String name;
    // 메모를 작성한 시간
    String time;
    // 메모 내용
    String content;

    // 생성자 - 멤버 필드 초기화
    public week82(String name, String time, String content) {
        this.name = name;
        this.time = time;
        this.content = content;
    }

    // 메모작성자가 같으면 true, 아니면 false
    public boolean isSameName(week82 b) {
        if (name.equals(b.getName())) return true;
        else return false;
    }

    // 메모작성자 이름 리턴
    public String getName() {
        return name;
    }

    // 메모 출력
    public void show() {
        System.out.println("작성자: " + name);
        System.out.println("시간: " + time);
        System.out.println("내용: " + content);
    }

    // 메모 텍스트의 길이 리턴
    public int length() {
        return content.length();
    }

    public static void main(String[] args) {
        week82 m1 = new week82("Jacob", "09:00", "오늘 수업 복습하기");
        week82 m2 = new week82("Jacob", "10:00", "과제 제출하기");
        week82 m3 = new week82("Kim", "11:00", "점심 약속");

        m1.show();
        System.out.println("메모 길이: " + m1.length());
        System.out.println("같은 작성자? " + m1.isSameName(m2)); // true
        System.out.println("같은 작성자? " + m1.isSameName(m3)); // false
    }
}