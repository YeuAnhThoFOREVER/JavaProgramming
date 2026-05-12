package week10;

interface AddInterface {
    int add(int x, int y);
    int add(int n);
}

class SimpleAdder implements AddInterface {
    public int add(int x, int y) {
        return x + y;
    }
    public int add(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) sum += i;
        return sum;
    }
}

public class W10_3 {
    public static void main(String[] args) {
        SimpleAdder adder = new SimpleAdder();
        System.out.println(adder.add(3, 10));
        System.out.println(adder.add(20));
    }
}