/*문제 05-01
사용자로부터 계속해서 정수를 입력받는다.
단 0을 입력받게되면 기존에 입력받은 모든 정수를 더한후 결과를 출력하는 프로그램을 작성하시오.
*/


import java.util.Scanner;

public class Quiz1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num;
		int num1 = 0;
		
		do {
			System.out.println("숫자를 입력하세요.");
			num = s.nextInt();
			num1 = (num1 + num);
			} 
		while(num != 0);
		
		System.out.println(num1);
	}

}
