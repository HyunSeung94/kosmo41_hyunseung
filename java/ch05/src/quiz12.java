/*���� 05-12
Do~While���� �̿��Ͽ� 1~1000���� ���ؼ� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
�������� �Ʒ��Ͱ��� ����Ͻÿ�.
��)1+2+3.......+1000 = 500500
*/
public class quiz12 {

	public static void main(String[] args) {
		int sum = 0;
		int num = 1;
		do {
			System.out.print(num+ " + " );
			sum = sum + num;
			num++;
		}while(num <= 1000);
		System.out.println("=" +sum);
		
		

	}

}
