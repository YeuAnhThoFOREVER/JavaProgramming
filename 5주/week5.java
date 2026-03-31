import java.util.Scanner;

public class week5 {

    public static void main(String[] args) {

        int intArray[];
        intArray = new int[5];
        int intMax = 0;

        Scanner scan = new Scanner(System.in);

        System.out.print("5개 양수 입력하기: ");
        for (int i = 0; i < 5; i++) {
            intArray[i] = scan.nextInt();
           intMax = intArray[i] + intMax;}
        
        int sum = intMax / 5 ;
        
        System.out.println("가장 큰 수는 " + sum + " 입니다.");
    }
}