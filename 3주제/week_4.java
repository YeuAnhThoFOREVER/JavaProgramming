import java.util.Scanner;

public class week_4 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요: ");
		
		int num = sc.nextInt();
		int n = num % 2;
		
		String result = (n==0) ? "짝수"  :  "홉수";
		
		System.out.println(result);
		sc.close();
	}
}