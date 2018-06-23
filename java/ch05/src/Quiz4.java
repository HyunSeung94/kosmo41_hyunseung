//문제 05-04
//두개의 정수를 입력 받아서 두 수의 차를 출력하는 프로그램을 작성하라.
//단 입력된 두 수의 순서에 상관없이 출력결과는 항상 0 이상이어야 한다.
//1과2를 입력했다면 1 .... 20과10을 입력했다면 10 ....
//위 프로그램을 작성해보자.

import java.util.Scanner;

public class Quiz4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int num = 0;
		int num1 = 0;
		
		System.out.println("첫번째 숫자를 입력하세요");
		num = s.nextInt();
		System.out.println("두번째 숫자를 입력하세요");
		num1 = s.nextInt();
		
		System.out.println( "두 정수의 차는 = "  + (num > num1 ? num - num1 : num1 - num));
	}
}

/*
		 if~else 문과 유사한 성격의 조건연산자로  조건 ? 
		x : y 이면 x 는 참일시 반환  y 는 거짓일시 반환		
		
		if(num>num1) {       // 조건에 참일시 num - num1을 사용하고
			System.out.println(num - num1);
		}
		else {               // 조건에 거짓일시 num1 - num을 사용
			System.out.println(num1 - num);
		}
	
	}

} */
