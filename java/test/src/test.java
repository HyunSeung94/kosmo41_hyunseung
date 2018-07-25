
public class test {

	public static void main(String[] args) {
		String str1 = "/to 홍길동 Hello~ hi";
		String str2 = "/list";
		String str3 = "안녕하세요";
		
		if(str1.indexOf("/to") >= 0) {
			int nTmp1 = str1.indexOf(" ");
			String strTmp = str1.substring(nTmp1+1);
			if(strTmp.indexOf("홍길동") ==0) {
			System.out.println(strTmp);
			}
			nTmp1 = strTmp.indexOf(" ");
			strTmp = strTmp.substring(nTmp1 +1);
			System.out.println(strTmp);
		}

	}

}
