import java.util.*;

public class TokenEx {

	public static void main(String[] args) {

		String s1 = "강산 위에 저 소나무 철갑을 두른 듯";

		String s2 = "2017/05/09";

		String s3 = "2017년05월09일";

		StringTokenizer t1 = new StringTokenizer(s1); // 공백으로 구분
		StringTokenizer t2 = new StringTokenizer(s2, "/"); // "/"으로 구분

		StringTokenizer t3 = new StringTokenizer(s3, "년월일"); // "년월일" 구분

		System.out.println("t1 count: " + t1.countTokens());
//		t1.nextToken();
//		System.out.println(t1.nextToken());  테스트용 
		

		for (int i = 1; t1.hasMoreTokens(); i++)

			System.out.println(i + " : " + t1.nextToken());

		System.out.println();

		System.out.println("t2 count: " + t2.countTokens());

		for (int i = 1; t2.hasMoreTokens(); i++)

			System.out.println(i + " : " + t2.nextToken());

		System.out.println();

		System.out.println("t3 count: " + t3.countTokens());

		for (int i = 1; t3.hasMoreTokens(); i++)

			System.out.println(i + " : " + t3.nextToken());

	}

}