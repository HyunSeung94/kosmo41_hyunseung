
public class SwitchBasic {

	public static void main(String[] args) {
		int n = 3;
		
		switch(n) {
		case 1:
			System.out.println("Siple java");break;        // break문이 실행되면 switch문을 빠져나간다.
		case 2:
			System.out.println("Funny java");break;        // break문이 실행되면 switch문을 빠져나간다.
		case 3:
			System.out.println("Fantastic java");break;    // break문이 실행되면 switch문을 빠져나간다.
		default:
			System.out.println("The best programming language");
			
		}

		System.out.println("Do you like java?");
	}

}
