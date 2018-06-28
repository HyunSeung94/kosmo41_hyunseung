
/*문제8
성적관리 프로그램을 작성한다. 국어, 영어, 수학, 국사 4과목이고
 학생은 이순신, 강감찬, 을지문덕, 권율 4명이다. 4 by 4 배열을  
 선언하고 사용자로부터 4사람의 4과목 점수를 입력받아 다음의 형태로
 값을 저장하고 총점을 구하는 프로그램을 작성하라.
*/
import java.util.Scanner;

public class Quiz13_8 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int arr[][] = new int[4][4];
		int sum1 =0, sum2 =0;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				switch(i) {
				case 0 : System.out.println("국어점수 : ");break;
				case 1 : System.out.println("영어점수 : ");break;
				case 2 : System.out.println("수학점수 : ");break;
				case 3 : System.out.println("국사점수 : ");break;
				}
				arr[i][j] = s.nextInt();
			}
		}
		System.out.println("구분\t이순신\t강감찬\t을지문\t권율\t총합");
		for(int i=0; i<arr.length; i++) {
			
			switch(i) {
			case(0) : System.out.print("국어:"+"\t"); break;
			case(1) : System.out.print("영어:"+"\t");break;
			case(2) : System.out.print("수학:"+"\t");break;
			case(3) : System.out.print("국사:"+"\t");break;
			}
			for(int j=0; j<arr.length; j++) {
				System.out.print(arr[i][j]+"\t");
				sum1= sum1+arr[i][j];
			} System.out.print(sum1);
			sum1 = 0;
			System.out.println();							
		}
		System.out.print("총점:"+"\t");
		for(int i=0; i<arr.length; i++) {
			sum2=0;
			for(int j=0; j<arr.length; j++ ) {
				sum2 += arr[j][i];
			}
			System.out.print(sum2 +"\t");
		}
	}
}