/*5-15
서로다른 3자리의 랜덤숫자 만들기
 * 중복되는수가 나오면안됨.
 */
import java.util.Random;

public class text {
	public static void main(String[] args) {
		Random random1 = new Random();
		while (true) {
			int num1 = random1.nextInt(9)+1 ;
			int num2 = random1.nextInt(9);
			int num3 = random1.nextInt(9);
			if (num1 != num2 && num2 != num3 && num3 != num1) {
				System.out.print(num1);
				System.out.print(num2);
				System.out.print(num3);
				break;
			}
		}
	}
}

