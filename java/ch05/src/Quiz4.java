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
