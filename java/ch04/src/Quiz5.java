import java.util.Scanner;

public class Quiz5 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		double num ;
		double sum = 0;
		
				
		System.out.println("��� ������ �Է� �Ͻðڽ��ϱ�?"); 
		int cnt = s.nextInt();  //ī��Ʈ
		for ( int i = 0; i < cnt; i++) {  //  i��  
			System.out.println((i+1) + " ��° ���� �Է�");   //
			num = s.nextInt();
			sum = sum + num;
		}
	
		
		
		System.out.println("�Է¹��� ������ ��հ��� = " + sum / cnt);


	}

}
