
public class BreakBasic {

	public static void main(String[] args) {
		int num = 1;
		boolean search = false;
		
		// 처음 만나는 5의배수이자 7의 배수인 수를 찾는 반복문
		while(num < 100) {
			if (((num % 5) == 0 ) && ((num % 7) == 0 )) {
				search = true;
				break;  // whileㅁ문을 탈출							
			}
			
			//num++;  
			num = num +2;
		}
		if(search)
			System.out.println("찾는 정수 : " + num);
		else
			System.out.println("5�� ������� 7�� ����� ���� ã�� ���߽��ϴ�.");
	}

}
