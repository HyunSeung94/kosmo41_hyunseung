/*5-04
두개의 정수를 입력 받아서 두 수의 차를 출력하는 프로그램을 작성하라.
단 입력된 두 수의 순서에 상관없이 출력결과는 항상 0 이상이어야 한다.
1과2를 입력했다면 1 .... 20과10을 입력했다면 10 ....
위 프로그램을 작성해보자.
*/

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
		 if~else ���� ������ ������ ���ǿ����ڷ�  ���� ? 
		x : y �̸� x �� ���Ͻ� ��ȯ  y �� �����Ͻ� ��ȯ		
		
		if(num>num1) {       // ���ǿ� ���Ͻ� num - num1�� ����ϰ�
			System.out.println(num - num1);
		}
		else {               // ���ǿ� �����Ͻ� num1 - num�� ���
			System.out.println(num1 - num);
		}
	
	}

} */
