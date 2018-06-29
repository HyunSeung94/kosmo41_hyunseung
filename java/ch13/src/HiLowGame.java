/*하이로우 게임 만들기

게임설명 :컴퓨터가 낸 숫자를 맞춘다.
기회는 6회 주어진다. (5회로 하면 난이도 상승)
숫자를 맞추거나 기회를 다 소진하면 다시 할  것인가를 물어본다.
*/
import java.util.Random;
import java.util.Scanner;

public class HiLowGame {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random rand = new Random();
		System.out.println("나는 지금 0 부터 100사이의 값 중에 하나를 생각 하겠습니다.");
		System.out.println("당신은 그숫자를 6회안에 맞추시면 됩니다..");
		int num1 = rand.nextInt(100) + 1;
		for (int i = 5; i >= 0; i--) {
			System.out.println("몇이라고 생각 합니까? <0 to 100>");
			int num2 = s.nextInt();
			if (num2 == num1) {
				System.out.println(num2 + "는 정답입니다. 축하합니다.");
				break;
			} else if (num2 > num1) {
				System.out.println(num2 + "는 제가 정한 숫자보다 큽니다.");

			} else if (num1 > num2) {
				System.out.println(num2 + "는 제가 정한 숫자보다 작습니다.");

			}
			if (i == 0) {
				System.out.println("High / Low 게임을 플레이해 주셔서 감사합니다.");
				System.out.println("다시하시겠습니까? <y/n>.....");
				String num3 = s.next();
				if(num3.equals("y")) {
					i=6;	
				}
				else if(num3.equals("n")) {
					System.out.println("수고하셨습니다.");
					break;
					
				}
				
			}
			System.out.println("[" + (i) + "]의 기회가 남았습니다.");
			System.out.println();

		}
	}
}
