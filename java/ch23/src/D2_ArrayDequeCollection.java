import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class D2_ArrayDequeCollection {

	public static void main(String[] args) {
		//둘다 사용 가능 
		Deque<String> deq = new LinkedList<>();
		//Deque<String> deq = new ArrayDeque<>();
		
		//앞으로 넣고
		deq.offerFirst("1.Box");
		deq.offerFirst("2.Toy");
		deq.offerFirst("3.Robot");
		
		//앞에서 꺼내기
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
		
		//뒤로 넣고
		deq.offerLast("1.Box");
		deq.offerLast("2.Toy");
		deq.offerLast("3.Robot");
		
		System.out.println(deq.pollLast());
		System.out.println(deq.pollLast());
		System.out.println(deq.pollLast());

		//뒤로 넣고 
		deq.offerLast("1.Box");
		deq.offerLast("2.Toy");
		deq.offerLast("3.Robot");
		
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
		System.out.println(deq.pollFirst());
	}

}
