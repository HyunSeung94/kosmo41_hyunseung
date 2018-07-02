import java.util.*;
public class StringTokenizew {

	public static void main(String[] args) {
		StringTokenizer v = new StringTokenizer("a,b,c", ",");// ,로 문자열을 분할하여 계산. 
		StringTokenizer n = new StringTokenizer("1 2 3");
		
		String s = v.nextToken();
		int sum = Integer.parseInt(n.nextToken());
		
		while (v.hasMoreTokens()) 
		{
			String str = v.nextToken();
			System.out.println(str);
			s = s + " + " + str;
			sum = sum + Integer.parseInt(n.nextToken());
		}
		System.out.println(s + " = " + sum);

	}

}
