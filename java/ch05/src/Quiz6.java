//문제 05-06
//사용자로부터 정수 하나를 입력받은 후 그 수에 해당하는 구구단을 역순으로 출력하시오.
	
import java.util.Scanner;

public class Quiz6 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("정수를 입력하세요");
		int z = s.nextInt();
			for(int j = 9; j > 0; j-- ) {
				System.out.println(z + " x " + j + " = " + (z * j));
			}
		}
	}
