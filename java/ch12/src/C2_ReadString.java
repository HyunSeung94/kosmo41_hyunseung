import java.util.Scanner;

public class C2_ReadString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("문자열 입력:");
		String str1 = sc.nextLine(); // String 이므로 .nextLine()

		System.out.println("문자열 입력");
		String str2 = sc.nextLine(); // String 이므로 .nextLine()

		System.out.printf("입력된 문자열 1: %s \n", str1);
		System.out.printf("입력된 문자열 2: %s \n", str2);
	}
}
// 스캐너 입력을만들때 입력받는 것에 따라 변경. (예)
//int .nextInt()
//byte .nextByte()
//String .nextLine()
//double .nextDouble()
//boolean .nextBoolean()