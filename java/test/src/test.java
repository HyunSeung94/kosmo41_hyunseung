
public class test {

	public static void main(String[] args) {
		String str1 = "/to 홍길동 Hello~ hi";
		String str2 = "/list";
		String str3 = "안녕하세요";
		//if(message.charAt(0) == '/')
		if(str1.indexOf("/to") >= 0) {
			int nTmp1 = str1.indexOf(" ");
			System.out.println(nTmp1);
			String strTmp = str1.substring(nTmp1+1);
			if(strTmp.charAt(0) =='홍' && strTmp.charAt(1) =='길' && strTmp.charAt(2) =='동') {
			System.out.println("1"+strTmp);
			System.out.println(strTmp.indexOf(0));
			}
			nTmp1 = strTmp.indexOf(" ");
			strTmp = strTmp.substring(nTmp1 +1);
			System.out.println("2"+strTmp);
			
			nTmp1 = strTmp.indexOf(" ");
			strTmp = strTmp.substring(nTmp1 +1);
			System.out.println("3"+strTmp);
			
			nTmp1 = strTmp.indexOf(" ");
			String str = strTmp.substring(nTmp1 +1);
			System.out.println("4"+str);
			if(strTmp != str) {
				System.out.println("하하");
				nTmp1 = strTmp.indexOf(" ");
				String str0 = strTmp.substring(nTmp1 +1);
				System.out.println("5"+str0);
				
			}
			
			
			
		}

	}

}
