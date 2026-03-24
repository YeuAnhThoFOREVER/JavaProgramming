import java.util.Scanner;

public class ex07 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("정수를 입력하세요");
		for (int i = 1; i <= 5; i++){
			int num = scan.nextInt();
			
			if(num < 0) { 
				continue ;
			}
			else {
				sum = sum + num;
			}
	
		}
		System.out.println("양수의 합은 :" + sum);
	scan.close();
	}
	

}
