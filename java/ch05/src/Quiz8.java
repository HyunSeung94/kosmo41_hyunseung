//문제 05-08
//사용자로부터 5개의 정수를 입력받아서 합을 구하여 출력한다.
//만약 입력받는 숫자가 1미만의 숫자라면 재입력을 요구해야 한다. 그래서 1이상의 정수 5개를 입력받아야 프로그램이 완성된다.

import java.util.Scanner;

public class Quiz8 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
    	int num ;
		int sum = 0;
		
				
		System.out.println("5개의 정수를 입력하세요"); 
		int cnt = 5;  //카운트
		for ( int i = 0; i < cnt; i++) {  //  i의  
			System.out.println((i+1) + " 번째 정수 입력");   //
			num = s.nextInt();
			while(num <1) {
				System.out.println("정수가 1미만으로 재입력하세요.");
				num = s.nextInt();
			}
			sum = sum + num;
		}
	
		
		
		System.out.println("입력받은 정수의 합 = " + sum);


	}

	}

