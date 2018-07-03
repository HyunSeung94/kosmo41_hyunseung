//문자열의 토근 구분예
import java.util.StringTokenizer;

public class G1_TokenizeString {

	public static void main(String[] args) {
		StringTokenizer st1 = new StringTokenizer("PM:08:45", ":");
		
		while(st1.hasMoreTokens())
			System.out.print(st1.nextToken()+ ' ');
		System.out.println();
		
		StringTokenizer st2 = new StringTokenizer("12 + 36 - 8 / 2 = 44", "+-/="); // 둘이상의 구분자! 공백도 구분자에 포함!@
				
				while(st2.hasMoreTokens())
					System.out.print(st2.nextToken() + ' ');
		System.out.println();


	}

}
