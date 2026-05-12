package week10;

class Book {
    private String title;
    protected Book(String title) { this.title = title; }
    protected String getTitle() { return title; }
}

class EBook extends Book {
    private int screenSize;

    public EBook(String title, int screenSize) {
        super(title);
        this.screenSize = screenSize;
    }

    public void printInfo() {
        System.out.println(getTitle() + "은 " + screenSize + "인치 전자책입니다.");
    }

    public void text2Speech(int page) {
        System.out.println(page + "페이지의 텍스트를 음성으로 출력합니다.");
    }
}

public class W10_2 {
    public static void main(String[] args) {
        EBook javaBook = new EBook("자바에센셜-전자책", 14);
        javaBook.printInfo();
        javaBook.text2Speech(3);
    }
}