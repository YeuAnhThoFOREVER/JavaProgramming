import java.util.Scanner;
public class question1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.print("나이를 입력하세요: ");
			
			Scanner scanner = new Scanner(System.in);
			
			int age = scanner.nextInt();
			
			if (age < 18) {
				System.out.println("청소년 관람 불가");
			}
			else {
				System.out.println("접근 요청리 승인됨");
			}
			scanner.close();
		
	}

}
