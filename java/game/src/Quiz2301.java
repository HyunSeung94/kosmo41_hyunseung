import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Quiz2301 {

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList();
		List<Integer> list2 = new ArrayList();
		List<Integer> kyo = new ArrayList();
		List<Integer> cha = new ArrayList();
		List<Integer> hap = new ArrayList();
		
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		
		list2.add(3);
		list2.add(4);
		list2.add(5);
		list2.add(6);
		
		//교집합, 차집함, 합집함을 구하시오.
		
		kyo.addAll(list1); //list1 모든게 다 kyo에 저장한다
		kyo.retainAll(list2); // list2 와kyo 겹치는 부분만 남기고 삭제한다 
		
		cha.addAll(list1);
		cha.removeAll(list2);  //cha에서 list2와 공통된 요소들을 모두 삭제한다.
		
		hap.addAll(list1);   
		hap.removeAll(list2);  //hap에서 kyo와 공통된 모든 요소를 삭제한다.
		hap.addAll(list2);    // list2의 모든 요소를 hap에 저장한다.
		
		
	
		
		//-------------------------------------
		System.out.println("list1=" + list1);
		System.out.println("list2=" + list2);
		System.out.println("kyo=" + kyo);
		System.out.println("cha=" + cha);
		System.out.println("hap=" + hap);

	}

}
