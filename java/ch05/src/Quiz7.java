//���� 05-07
//�л��� ���� ��ü ��������� ���� ������ ����ϴ� ���α׷��� �ۼ��϶�.
//����� ����, ����, ������ ������ ���ʷ� �Է¹��� �� ����� ���� ��
//90���̻� A, 80���̻� B, 70���̻� C, 50���̻� D, �� �̸��̸� F�� ����Ѵ�.
import java.util.Scanner;

public class Quiz7 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int sum = 0;
		System.out.println("���� ������ �Է��ϼ���");
		int A = s.nextInt();
		System.out.println(sum+A);
		System.out.println("���� ������ �Է��ϼ���");
		int B = s.nextInt();
		System.out.println(sum+B);
		System.out.println("���� ������ �Է��ϼ���");
		int C = s.nextInt();
		System.out.println(sum+C);
		
		int f = ((sum+A+B+C)/3);
		if(f >= 90 ) 
			System.out.println("���� A");
		else if(f >= 80 )
			System.out.println("���� B");
		else if(f >= 70)
			System.out.println("���� C");
		else if(f >= 50)
			System.out.println("���� D");
		else if(f < 50)
			System.out.println("���� F");
		
		
		

	}

}
