import java.util.Scanner;
public class week3_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scan = new Scanner(System.in);
		
		String id="hong", pwd="1234";
		
		System.out.println("아이디를 입력하세요: ");
		String myID = scan.next();
		
		System.out.println("비밀번호를 입력하세요: ");
		String myPwd = scan.next();
		
		
		if((myID.equals(id)) && (myPwd.equals(pwd))) {
			System.out.println("그로인 성공!!!");
			
		}else {
			System.out.println("그로인 슬패!!!.");
		}
		
		/*Scanner scan = new Scanner(System.in);
		System.out.println("숫자를 입력하세요: ");
		int num = scan.nextInt();
		
		if(num > 70 ) {
			System.out.println("합격입니다.");
			
		}else {
			System.out.println("불합격입니다.");
		}*/

		
		/*if(num % 2 ==0) {
			System.out.println("짝수입니다.");
			
		}else {
			System.out.println("홉수입니다.");
		}*/
		scan.close();

	}

}
