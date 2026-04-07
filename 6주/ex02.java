package week6;

import java.util.Scanner;

public class ex02 {

   
    public static int max(int a, int b) {
        int maxNum = a;
        if (b > maxNum) {
            maxNum = b;
        }
        return maxNum; 
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a, b, max;

        System.out.println("접수 1 입력하세요"); 
        a = scan.nextInt();
        System.out.println("접수 2 입력하세요");
        b = scan.nextInt();

        max = max(a, b); 
        scan.close();

        System.out.println("가장 큰 수는 " + max);
    }

}