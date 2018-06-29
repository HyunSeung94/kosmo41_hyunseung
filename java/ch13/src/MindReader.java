
/*내가 생각한 숫자를 컴퓨터가 맞춘다.
내가 생각한 숫자보다 크면 h 라고 입력한다.
내가 생각한 숫자보다 작으면 l 이라고 입력한다.
내가 생각한  숫자와 같으면 y 라고 입력한다.
 */
import java.util.Random;
import java.util.Scanner;

public class MindReader {

	public static void main(String[] args) {
		System.out.println("내가 생각한 숫자를 컴퓨터가 맞춘다. 1~100 범위");
		System.out.println("내가 생각한 숫자보다 크면 h 라고 입력한다.");
		System.out.println("내가 생각한 숫자보다 작으면 l 이라고 입력한다.");
		System.out.println("내가 생각한  숫자와 같으면 y 라고 입력한다");
		Scanner s = new Scanner(System.in);
		int max = 100;  int min = 0;
		String text;
		while(true) {
			System.out.println("is it = "+(min+max)/2);
			text = s.next();
			if(text.equals("h")) {
				min = (min + max) / 2;
			}
			else if(text.equals("l")) {
				max = (min + max) / 2;

			}
			else if(text.equals("y")) {
				System.out.println("끝이요.");
				break;
			}
		
		}

	}

}
