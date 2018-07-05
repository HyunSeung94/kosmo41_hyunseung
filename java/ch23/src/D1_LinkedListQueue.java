// 큐의 구현 
//LinkedList<E>는 List<E>와 동시에 Queue<E>를 구현하는 컬렉션 클래스이다.
//따라서 어떠한 타입의 참조변수로 참조하는냐에 따라 리스트로도 큐로도 동작한다.
import java.util.LinkedList;
import java.util.Queue;

public class D1_LinkedListQueue {

	public static void main(String[] args) {
		Queue<String> que = new LinkedList<>(); // LinkedList<E> 인스턴스 생성!
		que.offer("Box");
		que.offer("Toy");
		que.offer("Robot");
		
		
		// 무엇이 다음에 나올지 확인
		System.out.println("next: " + que.peek());
		
		
		// 첫 번째, 두 번째 인스턴스 꺼내기
		System.out.println(que.poll());
		System.out.println(que.poll());
		//System.out.println(que.poll()); Robot이 나오게되서 다음에 인스턴트를 꺼내면 null 반환됨
		
		
		
		// 무엇이 다음에 나올지 확인
		System.out.println("next: " + que.peek());
		
		
		// 마지막 인스턴스 꺼내기
		System.out.println(que.poll());

	}

}
