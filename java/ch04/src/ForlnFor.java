
public class ForlnFor {

	public static void main(String[] args) {
//		for(int i = 0; i < 3; i++) {
//			System.out.println("------------------");
//			for(int j = 0; j < 3; j++) {
//				System.out.print("[" + i + "," + j + "] ");
//					}
//			System.out.print('\n');
//		}
//	}
//}

		
		// 구구단 출력
		for(int i = 2; i < 10; i++ ) {   // 2단부터 9단까지 진행 위한 바깥쪽 for문
			for(int j = 1; j < 10; j++ )  //1부터 9까지의 곱을 위한 안쪽 for 문
				System.out.println(i + " x " + j + " = " + (i * j));
		}
		
		}
}

//  while문으로 출력  ㅜㅜ 