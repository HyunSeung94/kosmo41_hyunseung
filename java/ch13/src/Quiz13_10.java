
/*문제 10
길이가 4 by 4인 int형 배열을 선언하고 순서대로 1, 2, 3 … 정수를 입력하여 초기화하자.
그리고 배열의 요소들을 오른쪽 방향으로 90º씩 이동시켜서 그 결과를 출력하는 프로그램을 작성하라.
*/

public class Quiz13_10 {

	public static void main(String[] args) {

		int arr[][] = {
				{1,2,3,4,},
				{5,6,7,8},
				{9,10,11,12},
				{13,14,15,16}};

		for(int i = 0; i< 4; i++) {
			for(int j =0; j<4; j++) {
				System.out.print(arr[i][j]+"\t");
			}System.out.println();
		}
		System.out.println();
		for(int i = 0; i<4; i++) {
			for(int j =3; j>=0; j--) {  // j가 0보다 크거나 같을때까지 반복한다. 
				System.out.print(arr[j][i]+"\t");
			}System.out.println();
		}
		System.out.println();
		for(int i = 3; i>=0; i--) {
			for(int j =3; j>=0; j--) {
				System.out.print(arr[i][j]+"\t");
			}System.out.println();
		}
		System.out.println();
		for(int i = 3; i>=0; i--) {
			for(int j =0; j<4; j++) {
				System.out.print(arr[j][i]+"\t");
			}System.out.println();
		}
		System.out.println();

	}

}
