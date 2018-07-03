import java.util.Arrays;

public class H8_AttaySearch {

	public static void main(String[] args) {
		int[] ar = {33, 55, 11, 44, 22};
		Arrays.sort(ar);  // 탐색이전에 정렬이 선행되어야 한다.
		
		for(int n : ar)
			System.out.print(n + "\t");
		System.out.println();
		
		int idx = Arrays.binarySearch(ar, 33);
		System.out.println("Index of 33: " + idx);


	}

}
