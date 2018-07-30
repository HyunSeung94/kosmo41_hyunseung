import java.util.StringTokenizer;

public class zzzzzz {
	public static void main(String[] args) {
		String s= "/to 현승 ddd";
		StringTokenizer t1 = new StringTokenizer(s);
		int nTmp1 = s.indexOf(" ");
		String strTmp1 = s.substring(0,2);
		
//		t1.nextToken();
		t1.nextToken();
		
		String strTmp2 = t1.nextToken();
//		System.out.println(strTmp1);
		System.out.println(strTmp2);
	}

}
