//���� 05-02
//����ڷκ��� ���� ������� ������ �Է¹��� �� ����� ���Ͽ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
//��� ������ �Է��� �� ����ڷκ��� �Է¹޴´�
//�Է¹��� ���ڸ�ŭ ������ �Է¹޴´�.(����1���� 3�̶�� �Է��ߴٸ� 3���� ������ �Է¹޾ƾ� �Ѵ�)
//�Է¹��� ���ڵ��� ��հ��� ���Ͽ� ����Ѵ�. ��հ��� �Ҽ��� ���ϱ��� ����ؾ� �Ѵ�.
import java.util.Scanner;

public class Quiz2 {

	public static void main(String[] args) {
		
		Scanner s = new Scanner(System.in);   // �������� ���α׷��� �ϽŰ�. 
		System.out.println("���ڸ� �Է��ϼ���");
		int nCount = s.nextInt();
		double nSum = 0;
		
		for (int i=0; i < nCount; i++) {
			System.out.println("���ڸ� �Է��ϼ���. " );
			int nInputNum = s.nextInt();
			nSum = nSum + nInputNum;
		}
			System.out.println(nSum / nCount);
		}
}
		
		
		
		
		
		
		
		/*
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

} */
 
     
