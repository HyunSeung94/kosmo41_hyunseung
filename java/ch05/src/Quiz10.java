/*���� 05-10
����ڷκ��� 2���� ������ �Է¹޴´�. ���� 2�� 6�� �Է¹޾Ҵٸ�
2+3+4+5+6�� ���ϴ� ���α׷��� �ۼ��϶�.
�� 6�� 2�� �Է¹޴´ٸ� 6+5+4+3+2�� ���ؾ� �Ѵ�.*/
import java.util.Scanner;

public class Quiz10 {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println(" ������ �Է��ϼ���");
		int num = s.nextInt();
		System.out.println(" ������ �Է��ϼ���"); 
		int num1 = s.nextInt();
		int sum= 0;
		if(num>num1){
			for(int i=num; i>=num1;) {
				sum= sum + i;
				System.out.println(sum);
				i--;
			}
		}
		else {
			for(int i=num; i<=num1;) {
				sum= sum +i;
				System.out.println(sum);
				i++;				
				
			}
		}
		System.out.println(" 2���� ������ �� ���� " +sum);

	}

}
