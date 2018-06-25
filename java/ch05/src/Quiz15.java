
/*서로다른 3자리의 랜덤숫자 만들기
 * 중복되는수가 나오면안됨.
 */
import java.util.Random;

public class Quiz15 {
	public static void main(String[] args) {
		Random random1 = new Random();
		while (true) {
			int num1 = random1.nextInt(9) + 1;
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

/*
 * //Type #1 Random randomV1 = new Random();
 * 
 * System.out.println(randomV1.nextBoolean());
 * System.out.println(randomV1.nextFloat());
 * System.out.println(randomV1.nextInt());
 * System.out.println(randomV1.nextInt(100)); //range : 0 ~ 99
 * 
 * // Type #2 : 1~100 사이의 값 출력 double randomV2 = Math.random();
 * System.out.println("1 : " + randomV2); int intVal = (int)(randomV2 * 100) +
 * 1; System.out.println("2 : " + intVal); // (int)(Math.random() * (최대값 - 최소값 +
 * 1)) + 최소 }
 * 
 * }
 */