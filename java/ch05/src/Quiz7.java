//문제 05-07
//학생의 교내 전체 평균점수에 대한 학점을 출력하는 프로그램을 작성하라.
//실행시 국어, 영어, 수학의 점수를 차례로 입력받은 후 평균을 구한 후
//90점이상 A, 80점이상 B, 70점이상 C, 50점이상 D, 그 미만이면 F를 출력한다.
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
		else if(f >= 80 )
			System.out.println("학점 B");
		else if(f >= 70)
			System.out.println("학점 C");
		else if(f >= 50)
			System.out.println("학점 D");
		else if(f < 50)
			System.out.println("학점 F");
		
		
		

	}

}
