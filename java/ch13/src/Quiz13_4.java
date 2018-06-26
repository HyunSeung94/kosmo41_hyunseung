/*문제4
길이가 10인 배열을 선언한후 총 10개의 정수를 입력받는다.
단 홀수는 배열의 앞에서 부터 채워나가고 짝수는 배열의 끝에서부터 채워나간다.
출력예시) 총 10개의 정수를 입력하시오.
1 2 3 4 5 6 7 8 9 10결과 : 1 3 5 7 9 홀수||짝수10 8 6 4 2
*/
import java.util.Scanner;

public class Quiz13_4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int[] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			System.out.println(i + 1 + "번째 정수를 입력하세요");
			arr[i] = s.nextInt();
		}
		System.out.print("홀수 출력 : ");
		for (int i = 0; i < 10; i++) {
			if (arr[i] % 2 == 1) {
				System.out.print(arr[i] + " ");
			}
		}
		System.out.print("짝수 출력 : ");

		for (int i = arr.length-1; i>=0; i--) {
			if (arr[i] % 2 == 0) {
				System.out.print(arr[i] + " ");
			}
		}
	}
}