import java.util.Scanner;
public class question2 {
			
			public static void main(String[] args) {
				Scanner scanner = new Scanner(System.in);
				
				
				System.out.println("입사 시험 결과를 입력하세요:");
				
				int testpoint = scanner.nextInt(); 
				
				System.out.println("토익 시험 결과를 입력하세요:");

				int toeicponit = scanner.nextInt();
				
				if (testpoint >= 80 && toeicponit >= 850) {
					System.out.println("합격");
				}
				else {
					System.out.println("불합격");
				}
				scanner.close();
			}
			
			
}
