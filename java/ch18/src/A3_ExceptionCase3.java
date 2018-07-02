//try로 감싸야 할 영역의 결정
import java.util.InputMismatchException;
import java.util.Scanner;

public class A3_ExceptionCase3 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);

		try {
			System.out.println("a/b....a? ");
			int n1 = kb.nextInt(); // int형 정수 입력

			System.out.println("a/b....b? ");
			int n2 = kb.nextInt(); // int형 정수입력
			System.out.printf("%d / %d = %d \n", n1, n2, n1 / n2); // 예외 발생 지점
		} catch (InputMismatchException e) {
			e.getMessage();
		}
		System.out.println("Good bye~~!");

	}

}