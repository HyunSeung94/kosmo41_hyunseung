import java.util.Scanner;

public class Quiz5 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
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

}
