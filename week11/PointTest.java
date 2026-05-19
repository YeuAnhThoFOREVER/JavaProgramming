package day11;

class Point {
    // 정보은닉
    private int x, y;
    
    // 인자 생성자
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    // getter, setter
    public int getX() {
        return x;
    }
    
    public void setX(int x) {
        this.x = x;
    }
    
    public int getY() {
        return y;
    }
    
    public void setY(int y) {
        this.y = y;
    }
    
    // 메소드 오버라이딩 toString()
    @Override
    public String toString() {
        // Returns a string format like: Point(300, 500)
        return "Point(" + x + ", " + y + ")";
    }
}

public class PointTest {

    public static void main(String[] args) {
        
        Point point = new Point(300, 500);
        
        // This automatically calls the overridden toString() method
        System.out.println(point.toString()); 
        
    }
}