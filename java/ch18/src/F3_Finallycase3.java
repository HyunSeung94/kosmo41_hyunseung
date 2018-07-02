import java.util.Scanner;

public class F3_Finallycase3 {

	public static void main(String[] args) {
		int num;
		Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		
		try {
			num = a/ b;
		}catch(Exception e) {
		//	e.printStackTrace();
			num=0;
		}finally {
			//데이터 베이스 접속 종료등...무조건 해야할일 
			//num = num + 1;
		}
		System.out.println(num);
		

	}

}
