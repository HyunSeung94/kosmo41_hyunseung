//���� 05-08
//����ڷκ��� 5���� ������ �Է¹޾Ƽ� ���� ���Ͽ� ����Ѵ�.
//���� �Է¹޴� ���ڰ� 1�̸��� ���ڶ�� ���Է��� �䱸�ؾ� �Ѵ�. �׷��� 1�̻��� ���� 5���� �Է¹޾ƾ� ���α׷��� �ϼ��ȴ�.

import java.util.Scanner;

public class Quiz8 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);
    	int num ;
		int sum = 0;
		
				
		System.out.println("5���� ������ �Է��ϼ���"); 
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

