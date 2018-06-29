import java.util.Random;
import java.util.Scanner;

public class RPSGame {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random rand = new Random();
		int num1 = 0;
		int num2 = 0;
		String num3;
		while (true) {
			System.out.print("무엇을 내겠습니까?<1: 가위, 2:바위, 3:보> : ");
			num1 = s.nextInt();
			num2 = rand.nextInt(3) + 1;

			System.out.println("사용자 : " + num1 + "\t컴퓨터 : " + num2);

			if (num1 == 1 && num2 == 2 || num1 == 2 && num2 == 3 ||num1 == 3 && num2 == 1) {
				System.out.println("ㅜㅜㅜ졌습니다.ㅜㅜㅜ");
			} else if (num1 == 1 && num2 == 3 ||num1 == 2 && num2 == 1 || num1 == 3 && num2 == 2) {
				System.out.println("----이겼습니다.----");
			} else if (num1 == num2) {
				System.out.println("비겼습니다.");
			} else if (num2 >= 4) {
				System.out.println("잘못 입력했어요.");
			}
			

		}

	}

}
