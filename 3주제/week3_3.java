import java.util.Scanner;

public class week3_3 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		System.out.println("시간을 정수로 입력하세요: ");
		
		int time = scanner.nextInt();
		
		int second = time % 60;
		int minute = (time / 60) % 60;
		int hour = time / 3600;
		
		System.out.println(time + "은 " + hour + "시 " + minute + "분 " + second + "초 입니다.");
		
		scanner.close();
	}
}