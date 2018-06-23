//문제 05-02
//사용자로부터 다음 순서대로 정수를 입력받은 후 평균을 구하여 출력하는 프로그램을 작성하시오.
//몇개의 정수를 입력할 지 사용자로부터 입력받는다
//입력받은 숫자만큼 정수를 입력받는다.(조건1에서 3이라고 입력했다면 3개의 정수를 입력받아야 한다)
//입력받은 숫자들의 평균값을 구하여 출력한다. 평균값은 소수점 이하까지 계산해야 한다.
import java.util.Scanner;

public class Quiz2 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);   // 선생님이 프로그래밍 하신거. 
		System.out.println("숫자를 입력하세요");
		int nCount = s.nextInt();
		double nSum = 0;
		
		for (int i=0; i < nCount; i++) {
			System.out.println("숫자를 입력하세요. " );
			int nInputNum = s.nextInt();
			nSum = nSum + nInputNum;
		}
			System.out.println(nSum / nCount);
		}
}
		
		
		
		
		
		
		
		/*
    	double num ;
		double sum = 0;
		
				
		System.out.println("몇개의 정수를 입력 하시겠습니까?"); 
		int cnt = s.nextInt();  //카운트
		for ( int i = 0; i < cnt; i++) {  //  i의  
			System.out.println((i+1) + " 번째 정수 입력");   //
			num = s.nextInt();
			sum = sum + num;
		}
	
		
		
		System.out.println("입력받은 정수의 평균값은 = " + sum / cnt);


	}

} */
 
     
