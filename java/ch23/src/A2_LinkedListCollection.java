// 리스트 기반 자료구조는 열차 칸을 더하고 뺴는 형태의 자료구조이다.
// 인스턴스 저장  (열차칸을 하나 더한다.)
// 인스턴스 삭제  (해당열 차 칸을 삭제한다)
import java.util.LinkedList;
import java.util.List;

public class A2_LinkedListCollection {
	public static void main(String[] args) {
		List<String> list = new LinkedList<>();  // 컬렉션 인스턴스 생성

		//컬렉션 인스턴스에 문자열 인스턴스 저장
		list.add("Toy");
		list.add("Box");
		list.add("Box"); //중복이 허용된다. 
		list.add("Robot");
		
		//저장된 문자열 인스턴스참조
		for(int i = 0; i< list.size(); i++)
			System.out.println(list.get(i) + '\t');
		System.out.println();
		
		list.remove(0); //첫번째 인스턴스삭제
		
		//첫번째 인스턴스 삭제후 나머지 인스턴스들을 참조
		for(int i = 0; i< list.size(); i++)
			System.out.println(list.get(i) + '\t');
		System.out.println();
		

	}

}

