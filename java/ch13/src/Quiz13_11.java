/*중복되지 않는 3개의 정수를 생성한다.
사용자는 3개의 숫자를 입력한다.
생성된 3개의 숫자를 맞추는데 위치까지 정확히 맞춰야 한다.숫자와 숫자의 위치까지 일치하면 strike 로 판정한다.
숫자는 맞지만 위치가 틀렸다면 ball로 판정한다.
숫자3개가 모두 일치하지 않으면  out으로 판정한다.
3 strike 가 되면 게임은 종료된다.
시도한 횟수를 표시한다.
*/
import java.util.Random;
import java.util.Scanner;

public class Quiz13_11 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Random rand = new Random();
		int num, num1, num2, num3, text, text1, text2, text3, text4, cnt = 0;

		num = rand.nextInt(9) + 1;
		num1 = rand.nextInt(10);
		num2 = rand.nextInt(10);

		while (true) {
			if (num != num1 && num1 != num2 && num2 != num) {
				break;
			}
		}
		num3 = num * 100 + num1 * 10 + num2; // 100의자리 10의자리 1의자리를설정해준걸 num3에 선언
		// System.out.println(num3); // 컴퓨터가설정한 3개의정수
		while (true) {
			int acnt = 0;
			int bcnt = 0;
			System.out.println("숫자로 하는 야구게임시작이에요! ");
			cnt++;
			System.out.println("세자리 숫자를 입력하세요! (" + cnt + "회)");
			text = s.nextInt(); // 3자리숫자를 입력한다.
			text1 = text / 100; // text함수의 100의자리를 만듬
			text2 = (text - text1 * 100) / 10; // text함수의 10의 자리를 만듬
			text3 = text - (text1 * 100) - (text2 * 10); // text 함수의 1의자리를 만듬
			System.out.println(text1 + ":" + text2 + ":" + text3);

			text4 = text1 * 100 + text2 * 10 + text3;
			if (num3 == text4) {
				System.out.println("3 Strike!!  0ball  ");
				System.out.println("너가 이겼어! ");
				break;
			}
			if (text1 == num) {
				acnt = acnt + 1;
			} // strike 를 알려줌 acnt를 1올려줌으로써 스트라이크 1증가
			if (text2 == num1) {
				acnt = acnt + 1;
			} // strike 를 알려줌 acnt를 1올려줌으로써 스트라이크 1증가
			if (text3 == num2) {
				acnt = acnt + 1;
			} // strike 를 알려줌 acnt를 1올려줌으로써 스트라이크 1증가

			if (text1 == num1 || text1 == num2) {
				bcnt = bcnt + 1;
			} // bcnt를 올려줌으로써 Ball 현황 확인
			if (text2 == num || text2 == num2) {
				bcnt = bcnt + 1;
			} // bcnt를 올려줌으로써 Ball 현황 확인
			if (text3 == num || text3 == num1) {
				bcnt = bcnt + 1;
			} // bcnt를 올려줌으로써 Ball 현황 확인

			System.out.println(acnt + "Strike \t" + bcnt + "Ball"); // 볼과 스트라이크의 출력을 확인함.
		}

	}

}
