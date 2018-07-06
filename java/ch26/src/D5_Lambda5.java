//파라미터가 여러개일때 사용하면좋다. 
interface Printable8 {
	void print(String s, int n);
}

public class D5_Lambda5 {

	public static void main(String[] args) {
		Printable8 prn = (s, n) -> {
			System.out.println(s + ":" + n);
		};
		prn.print("What is Lambda?", 5);

	}

}
