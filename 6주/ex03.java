package week6;

import java.util.Scanner;

public class ex03 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 

        int a, b, result;  
        String s;

        System.out.println("접수 1를 입력하세요.");
        a = sc.nextInt();
        System.out.println("접수 2를 입력하세요.");
        b = sc.nextInt();

        System.out.println("연산 부호를 입력하세요.");
        s = sc.next(); 

        switch (s) { 
            case "+":
                result = a + b;
                System.out.println(a + "+" + b + "=" + result);
                break;
            case "-":
                result = a - b;
                System.out.println(a + "-" + b + "=" + result);
                break;
            case "*":
                result = a * b;
                System.out.println(a + "*" + b + "=" + result);
                break;
            case "/":
                result = a / b;
                System.out.println(a + "/" + b + "=" + result);
                break;
            default: 
                System.out.println("유효하지 않은 연산 부호입니다.");
        }
        

        sc.close(); 
    }

}