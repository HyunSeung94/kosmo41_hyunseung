/*
���� 05-11
���� �ϳ��� �Է¹����� �� ����
���丮�� �Լ��� ����� ����ϴ� ���α׷��� while���� �̿��Ͽ� �����Ͻÿ�.
��¿�) �Է����� : 5*4*3*2*1 = 120
 */
import java.util.Scanner;
public class Quiz11 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println(" ������ �Է��ϼ���");
		int num = s.nextInt();
		int sum = 1;
		
		while(num>=1) {
			System.out.println(sum+" * " + num + " = " );
			sum = sum * num;
			System.out.println(sum);
			num--;			
		}
		System.out.println(" ���丮�� �Լ� ��� = " + sum);

	}

}
