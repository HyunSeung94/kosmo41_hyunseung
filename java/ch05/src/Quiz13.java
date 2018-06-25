/*문제 05-13
중첩 for문을 이용하여 구구단 전체를 출력하는 프로그램을 작성하시오.
단 가로형, 세로형 둘다 만들어야함.
*/
public class Quiz13 {

	public static void main(String[] args) {

		System.out.println("가로");
		for(int i = 1; i<10; i++) {
			for(int j = 2; j<10; j++) {
				System.out.print(j + " * " +i + "= " + (j*i)+"\t");
			}
			System.out.print('\n');

		}
		System.out.println("세로");
		for(int i = 2; i<10; i++) {
			for(int j = 1; j<10; j++) {

				System.out.print(i + " * " +j + "= " + (i*j)+"  ");
			}
			System.out.print('\n');
		}

		
	}
	}

