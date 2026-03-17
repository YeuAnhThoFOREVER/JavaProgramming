import java.util.Scanner;

public class week3 {

	public static void main(String[] args) {
		int age;
		String name;
		double height;

		try (Scanner scan = new Scanner(System.in)) {
			System.out.print("나이를 입력하세요: ");
			age = scan.nextInt();
			scan.nextLine(); // clear buffer

			System.out.print("키를 입력하세요: ");
			height = scan.nextDouble();
			scan.nextLine(); // clear buffer again

			System.out.print("이름을 입력하세요: ");
			name = scan.nextLine();
		}

		System.out.println("나이: " + age);
		System.out.println("이름: " + name);
		System.out.println("키: " + height +"cm");
	}
}