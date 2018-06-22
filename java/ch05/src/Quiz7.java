import java.util.Scanner;

public class Quiz7 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int sum = 0;
		System.out.println("국어 점수를 입력하세요");
		int A = s.nextInt();
		System.out.println(sum+A);
		System.out.println("영어 점수를 입력하세요");
		int B = s.nextInt();
		System.out.println(sum+B);
		System.out.println("수학 점수를 입력하세요");
		int C = s.nextInt();
		System.out.println(sum+C);
		
		int f = ((sum+A+B+C)/3);
		if(f >= 90 ) 
			System.out.println("학점 A");
		else if(f <= 80 )
			System.out.println("학점 B");
		if(f <= 70)
			System.out.println("학점 C");
		else if(f <= 50)
			System.out.println("학점 D");
		if(f <= 50)
			System.out.println("학점 F");
		
		
		

	}

}
