/*문제 05-14
다음 식을 만족하는 모든 A와 Z를 구하는 프로그램을 작성하라
 AZ
+ZA
-----
 99
단, A와 Z는 서로다른 숫자이다.
*/
public class Quiz14 {

	public static void main(String[] args) {

		int A = 0;
		int Z = 0;
		int sum = 0;

		for (A = 0; A <= 9; A++) {
			for (Z = 9; Z <= 9; Z--) {

				sum = (10 * A + Z) + (10 * Z + A);

				if (sum == 99)
					System.out.println("결과값: " + A + Z + "+" + Z + A + " = " + sum);

			}
		}
	}
}