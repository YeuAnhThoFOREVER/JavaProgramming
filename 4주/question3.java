import java.util.Scanner;
public class question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("나이를 입력하시오: ");
		
		int balance = 10000;
		
		int age = scanner.nextInt();
		
		if ( age >= 7 && age <= 12) {
			System.out.println("어런이 티켓 ---450원---");
			 balance = (balance - 450);}
		else if ( age > 12 && age <= 18 ) {
			System.out.println("청소년 티켓 ---720원---");
			balance = (balance - 720);}
		else {
			System.out.println("어른 티켓 ---1200원---");
			balance = (balance - 1200);
		}
		System.out.println("잔액 " + balance +"원" );
			
		scanner.close();
		} 

}
