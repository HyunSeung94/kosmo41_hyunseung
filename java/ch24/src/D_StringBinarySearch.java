// 찾기의 예 
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class D_StringBinarySearch {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("Box");
		list.add("Robot");
		list.add("Apple");
		
		// 정렬이 먼저다!
		Collections.sort(list); 
		
		// 탐색
		int idx = Collections.binarySearch(list, "RObox");
		
		 // 탐색의 결과 출력
		System.out.println(list.get(idx));

	}

}
