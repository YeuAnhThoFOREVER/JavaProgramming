public class Circle {
    public double radius;
    public String name;

    public Circle() { }

    public Circle(double radius, String name) {
        this.radius = radius;
        this.name = name;
    }

    public double getArea() {
        return 3.14 * radius * radius;
    }
}