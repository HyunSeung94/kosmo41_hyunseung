import java.util.Scanner;

public class Quiz1 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int num;
		int num1 = 0;
		
		do {
			System.out.println("���ڸ� �Է��ϼ���");
			num = s.nextInt();
			num1 = (num1 + num);
			} 
		while(num != 0);
		
		System.out.println(num1);
	}

}
