public class PizzaTest {
    public static void main(String[] args) {

        Pizza p1 = new Pizza("페퍼로니 + 치즈", 15000, 15.0, "페퍼로니 피자");
        p1.showInfo();
        p1.eat();

        System.out.println();

        Pizza p2 = new Pizza("불고기 + 양파", 17000, 18.0, "불고기 피자");
        p2.showInfo();
        p2.eat();
    }
}