import java.util.Scanner;

public class Quiz4 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int num = 0;
		int num1 = 0;
		
		System.out.println("ù��° ���ڸ� �Է��ϼ���");
		num = s.nextInt();
		System.out.println("�ι�° ���ڸ� �Է��ϼ���");
		num1 = s.nextInt();
		
		System.out.println( "�� ������ ���� = "  + (num > num1 ? num - num1 : num1 - num));
	}
}

/*
		 if~else ���� ������ ������ ���ǿ����ڷ�  ���� ? 
		x : y �̸� x �� ���Ͻ� ��ȯ  y �� �����Ͻ� ��ȯ		
		
		if(num>num1) {       // ���ǿ� ���Ͻ� num - num1�� ����ϰ�
			System.out.println(num - num1);
		}
		else {               // ���ǿ� �����Ͻ� num1 - num�� ���
			System.out.println(num1 - num);
		}
	
	}

} */
