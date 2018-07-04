//
// 배열기반 자료구조이지만 공간의 확보 및 확장은  
// ArrayList 인스턴스가 스스로 처리한다.
//
import java.util.ArrayList;
import java.util.List;

public class A1_ArrayListCollection {

	public static void main(String[] args) {
		List<String> list = new ArrayList<>();  // 컬렉션 인스턴스 생성

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
