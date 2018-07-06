interface Printable6 { // 추상 메소드가 하나인 인터페이스
	void print(String s);
}


public class D3_Lambda3 {

	public static void main(String[] args) {
		Printable6 prn = (s)  -> {System.out.println(s); };
		prn.print("What is Lambda?");

	}

}
