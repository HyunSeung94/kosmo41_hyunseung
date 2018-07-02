//선생님이만드신거. 13_10문제. 
public class Quiz13_10_1 {

	public static void main(String[] args) {
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		arrPrint(arr);

		for (int k = 0; k < 3; k++) {
			int[][] arr2 = new int[4][4];
			int x;
			int y;
			y = 0;
			for (int i = 0; i < 4; i++) {
				x = 3;
				for (int j = 0; j < 4; j++) {
					arr2[i][j] = arr[x][y];
					x--;
				}
				y++;
			}

			// 원래 배열에 값을 다시복사.
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					arr[i][j] = arr2[i][j];
				}
			}

			arrPrint(arr2);
		}

	}
	
	public static void arrPrint(int[][] arr) {
	for(int i = 0; i<4; i++) {
		for(int j=0; j<4; j++){
			System.out.printf("%2d ", arr[i][j]);
		}
		System.out.println();
	}
	System.out.println();
		}
	}


