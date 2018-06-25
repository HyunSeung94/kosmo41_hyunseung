/*문제 05-10
사용자로부터 2개의 정수를 입력받는다. 가령 2와 6을 입력받았다면
2+3+4+5+6을 구하는 프로그램을 작성하라.
단 6과 2를 입력받는다면 6+5+4+3+2를 구해야 한다.*/
import java.util.Scanner;

public class Quiz10 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println(" 정수를 입력하세요");
		int num = s.nextInt();
		System.out.println(" 정수를 입력하세요"); 
		int num1 = s.nextInt();
		int sum= 0;
		if(num>num1){
			for(int i=num; i>=num1;) {
				sum= sum + i;
				System.out.println(sum);
				i--;
			}
		}
		else {
			for(int i=num; i<=num1;) {
				sum= sum +i;
				System.out.println(sum);
				i++;							
			}
		}
		System.out.println(" 2개의 정수의 총 합은 " +sum);
	}
}

