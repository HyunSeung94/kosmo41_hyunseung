/*문제 05-03 
1이상 100미만의 정수중에서 7의배수와 9의배수를 출력하는 프로그램을 작성하라.
단, 7의 배수이면서 동시에 9의 배수인 정수는 한번만 출력해야 한다.
*/

public class Quiz3 {

	public static void main(String[] args) {
		
		System.out.println("7 과 9의 배수는");
		for (int i= 1; i < 100; i++) {
			if((i%7) == 0 || (i%9) ==0 )
				
				System.out.println(i);						
		}
		

	}

}
// �� (x) ���� ��(y)���� (�̸�����)
//     --> �ݺ��� :for  (int i=x; i < y; i++)
// ��� ~ --> �ݺ���
//n�� ��� --> (���� %n ==0)