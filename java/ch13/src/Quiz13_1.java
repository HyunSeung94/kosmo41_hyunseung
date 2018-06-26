
/*문제1
길이가 5인 int형 배열을 선언해서 사용자로부터 5개의 정수를 입력받는다.	
그리고 최대값, 최소값, 모든 수의 합을 구하라. 함수(최대,최소,합)를 정의하여 구현하시오.
클래스를 만들 경우 배열을 인자로 넘기기
메인에서 다 처리해도 됨
*/
import java.util.Scanner;

public class Quiz13_1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("5개의 정수를 입력하세요");
		int[] ar = new int[5];
		int sum = 0;
		int max = 0;
		int min = 1000;

		for (int i = 0; i < 5; i++) {
			System.out.println(+i + 1 + "번째" + "정수를 입력하세요");
			ar[i] = s.nextInt();
			sum = sum + ar[i];
			if (max < ar[i]) {
				max = ar[i];
			}

			if (min > ar[i]) {
				min = ar[i];
			}
		}
		System.out.println("정수의 합" + sum);
		System.out.println("정수의 최대값" + max);
		System.out.println("정수의 최소값" + min);

	}

}
