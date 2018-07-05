import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random rand = new Random();
		String arr[][] = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "x", "8" } };
		String arr1[][] = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "x" } };
		String change;
		String a;

		int c = 0;
		do {
			int b = rand.nextInt(4);
			if (b == 0) {
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr.length; j++) {

						if (arr[i][j] == "x") {
							if (j <= 0) {
								continue;
							}
							change = arr[i][j];
							arr[i][j] = arr[i][j - 1];
							arr[i][j - 1] = change;
						}
					}
				}
				System.out.println();
			}

			if (b == 1) {

				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr.length; j++) {
						if (arr[i][j] == "x") {
							if (j >= 2) {
								continue;
							}
							change = arr[i][j];
							arr[i][j] = arr[i][j + 1];
							arr[i][j + 1] = change;

						}
					}
				}
				System.out.println();
			}
			if (b == 2) {
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr.length; j++) {
						if (arr[i][j] == "x") {
							if (i >= 2) {
								continue;
							}
							i++;
							change = arr[i][j];
							arr[i][j] = arr[i - 1][j];
							arr[i - 1][j] = change;

						}
					}
				}
				System.out.println();
			}

			if (b == 3) {
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr.length; j++) {
						if (arr[i][j] == "x") {
							if (i <= 0) {

								continue;
							}
							i--;
							change = arr[i][j];
							arr[i][j] = arr[i + 1][j];
							arr[i + 1][j] = change;

						}
					}
				}
				System.out.println();
			}
			c++;

		} while (c < 100);

		for (;;) {

			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					System.out.print(arr[i][j]);
					if(j<2) {
						System.out.print(" | ");
					}
				}
				if(i<2) {
				System.out.println();
				System.out.print("--|---|--");
				System.out.println();
				}
			}System.out.println();

			System.out.println("[ Move ] a:Left s:Right w:Up z:Down");
			System.out.println("[ Exit ] k:Exit");
			System.out.println("이동키를 입력하세요");
			a = s.next();

			if (a.equals("a")) {
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr.length; j++) {

						if (arr[i][j] == "x") {
							if (j <= 0) {
								System.out.println("잘못입력했어요");
								continue;
							}
							change = arr[i][j];
							arr[i][j] = arr[i][j - 1];
							arr[i][j - 1] = change;
						}
					}
				}
				System.out.println();
			}
			if (a.equals("s")) {
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr.length; j++) {
						if (arr[i][j] == "x") {
							if (j >= 2) {
								System.out.println("잘못입력했어요!! 다시입력하세요~");
								continue;
							}
							change = arr[i][j];
							arr[i][j] = arr[i][j + 1];
							arr[i][j + 1] = change;
							break;
						}
					}
				}
				System.out.println();
			}
			if (a.equals("z")) {
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr.length; j++) {
						if (arr[i][j] == "x") {
							if (i >= 2) {
								System.out.println("잘못입력했어요!! 다시입력하세요~");
								continue;
							}
							i++;
							change = arr[i][j];
							arr[i][j] = arr[i - 1][j];
							arr[i - 1][j] = change;

						}
					}
				}
				System.out.println();
			}
			if (a.equals("w")) {
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr.length; j++) {
						if (arr[i][j] == "x") {
							if (i <= 0) {
								System.out.println("잘못입력했어요!! 다시입력하세요~");
								continue;
							}
							i--;
							change = arr[i][j];
							arr[i][j] = arr[i + 1][j];
							arr[i + 1][j] = change;

						}
					}
				}
				System.out.println();
			}
			if(arr[0][0] == arr[0][1] == arr[0][2] )

			if (Arrays.deepEquals(arr, arr1)) { // 배열끼리 비교문
				System.out.println("정답입니다.. 수고하셧습니다! ");
				break;
			}

		}

	}
}