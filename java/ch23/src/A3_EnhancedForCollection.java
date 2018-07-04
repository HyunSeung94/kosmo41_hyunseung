import java.util.LinkedList;
import java.util.List;

public class A3_EnhancedForCollection {

	public static void main(String[] args) {
		List<String> list = new LinkedList<>();  // 컬렉션 인스턴스 생성

		//컬렉션 인스턴스에 문자열 인스턴스 저장
		list.add("Toy");
		list.add("Box");
		list.add("Box"); //중복이 허용된다. 
		list.add("Robot");
		


		for(String s: list)//첫번째 인스턴스삭제
			System.out.println(s + '\t');
		System.out.println();
		
		list.remove(0);
		for(int i = 0; i< list.size(); i++)
			System.out.println(list.get(i) + '\t');
		System.out.println();
		
	}

}
