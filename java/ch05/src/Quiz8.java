import java.util.Scanner;

public class Quiz8 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
    	int num ;
		int sum = 0;
		
				
		System.out.println("��� ������ �Է� �Ͻðڽ��ϱ�?"); 
		int cnt = 5;  //ī��Ʈ
		for ( int i = 0; i < cnt; i++) {  //  i��  
			System.out.println((i+1) + " ��° ���� �Է�");   //
			num = s.nextInt();
			while(num <1) {
				System.out.println("������ 1�̸����� ���Է��ϼ���.");
				num = s.nextInt();
			}
			sum = sum + num;
		}
	
		
		
		System.out.println("�Է¹��� ������ �� = " + sum);


	}

	}

