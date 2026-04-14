public class Pizza {
    public String topping;
    public int price;
    public Circle size;

    public Pizza(String topping, int price, double radius, String name) {
        this.topping = topping;
        this.price = price;
        this.size = new Circle(radius, name);
        System.out.println("객체가 생성됨.");
    }

    public void showInfo() {
        System.out.println("=== 피자 정보 ===");
        System.out.println("이름: " + size.name);
        System.out.println("토핑: " + topping);
        System.out.println("가격: " + price + "원");
        System.out.printf("크기(넓이): %.2f cm²%n", size.getArea());
    }

    public void eat() {
        System.out.println(size.name + "을(를) 먹습니다!");
    }
}