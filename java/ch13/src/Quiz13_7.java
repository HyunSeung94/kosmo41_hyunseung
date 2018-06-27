/*문제7
우선 아래와 같은 형태의 좌측배열 A를 선언한다. 그리고 
A배열의 초기값을 이용해서 우측배열 B를 초기화하는 프로그램을 작성하시오
*/
public class Quiz13_7 {

	public static void main(String[] args) {
		int[][] ar1 = {
				{ 1, 2, 3, 4 }, { 5, 6, 7, 8 } 
				};

		int[][] ar2 = new int[4][2];
		for (int i = 0; i < ar1.length; i++) {
			for (int j = 0; j < ar1[i].length; j++) {
				System.out.print(ar1[i][j] + "\t");
				ar2[j][i] = ar1[i][j];
			}
			System.out.println();
		}
		System.out.println("----------------");

		for (int i = 0; i < ar2.length; i++) {
			for (int j = 0; j < ar2[i].length; j++) {
				System.out.print(ar2[i][j] + "\t");
			}
			System.out.println();
		}

	}

}
