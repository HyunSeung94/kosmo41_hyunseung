
public class ContinueBasic {

	public static void main(String[] args) {
		int num = 0;
		int count = 0;
		
		while(num < 100) {
			num++;
			if(((num % 5) != 0) || ((num % 7) != 0))  //  num�� 5�϶�%5�� 0�̼��������� %7�� �����̾ȵǹǷ�
			{		
				continue;
			}
			count++;
			System.out.println(num);  // 5�� 7�� ����� ��츸 ����
		}
		System.out.println("count: " + count);

	}

}
