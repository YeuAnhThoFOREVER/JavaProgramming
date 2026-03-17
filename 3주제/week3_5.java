import java.util.Scanner;
public class week3_5 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); 
			
			System.out.println("학점을 입력하세요");
			int point = scanner.nextInt();
			
			if (point >= 90) {
				System.out.println("A를 받았어요");
			}
			else if (point >= 80) {
				System.out.println("B를 받았어요");
			}
			else if (point >= 70) {
				System.out.println("C를 받았어요");
			}
			else {
				System.out.println("F를 받았어요");
			}
		
		
		// TODO Auto-generated method stub

		scanner.close();
	}

}
