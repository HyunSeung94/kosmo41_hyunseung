//파라미터를 람다식으로 넘길때 
interface Printable7 { // 추상 메소드가 하나인 인터페이스
	void print(String s);
}

public class D4_Lambda4 {

	public static void ShowString(Printable7 p, String s) {
		p.print(s);
	}

	public static void main(String[] args) {
		ShowString((s) -> { System.out.println(s); }, "What is Lambda?");
	}

}
