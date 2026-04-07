package week6;

import java.util.Scanner;

public class week6 {

    // Fix 3: Renamed to avoid duplicate main, added String[] args
    public static void readAndAdd(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int num2 = scan.nextInt();
        System.out.println(num + num2);
        scan.close();
    }

    // Fix 1 & 2: Removed underscores, added return statement
    public static int add2(int a, int b) {
        System.out.println(a + b);
        return a + b;
    }

    public static void main(String[] args) {
        // Fix 4: Changed __add3__ to add2 (method doesn't exist)
        int result = add2(50, 60);
        // Fix 5: Added result to println
        System.out.println(result);
    }

}