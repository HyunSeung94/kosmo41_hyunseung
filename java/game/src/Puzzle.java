import java.util.Scanner;

public class Puzzle {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String arr[][] = { { "1", "x", "2" }, { "7", "6", "3" }, { "4", "8", "5" } };
		String change;
		String a;

		for (;;) {
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					System.out.print(arr[i][j]);
				}
				System.out.println();

			}

			System.out.println("[ Move ] a:Left s:Right w:Up z:Down");
			System.out.println("[ Exit ] k:Exit");
			System.out.println("이동키를 입력하세요");
			a = s.next();

			if (a.equals("a")) {
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr.length; j++) {
						if (arr[i][j] == "x") {
							change = arr[i][j];
							arr[i][j] = arr[i][j+1];
							arr[i][j+1] = change;
						}
					}
				}
			}
			if (a.equals("s")) {
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr.length; j++) {
						if (arr[i][j] == "x") {
							change = arr[i][j-1];
							arr[i][j-1] = arr[i][j];
							arr[i][j] = change;
						}
					}
				}
			}


		}

	}
}
