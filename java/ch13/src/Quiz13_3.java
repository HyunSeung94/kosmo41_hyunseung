
/*문제3
길이가 10인 배열을 선언하고 총 10개의 정수를 입력받아서 홀수와 짝수를
구분해서 출력하라.
출력예시) 총 10개의 숫자를 입력하시오.
1 2 3 ....... 10개입력
홀수출력 : 1, 3, 5, 7
짝수출력 : 2, 4, 6, 8, 10
*/
import java.util.Scanner;

public class Quiz13_3 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			System.out.println(i + 1 + "번째 정수를 입력하세요");
			arr[i] = s.nextInt();
		}
		System.out.print("짝수 출력 : ");

		for (int i = 0; i < 10; i++) {
			if (arr[i] % 2 == 0) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.println();
		System.out.print("홀수 출력 : ");
		for (int i = 0; i < 10; i++) {
			if (arr[i] % 2 == 1) {
				System.out.print(arr[i] + " ");
			}
		}
	}
}
