/*
 * 쓰레드를 생성하는 두번째 방법
 */
class Task extends Thread {
	public void run() { // Thread의 run 메소드 오버라이딩
		int n1 = 10;
		int n2 = 20;
		String name = Thread.currentThread().getName();
		System.out.println(name + ": " + (n1 + n2));
	}
}

public class A4_MakeThreadDemo2 {

	public static void main(String[] args) {
		Task t1 = new Task();
		Task t2 = new Task();
		t1.start();
		t2.start();
		System.out.println("End " + Thread.currentThread().getName());
	}

}
/*• 1단계 Thread를 상속하는 클래스의 정의와 인스턴스 생성
• 2단계 start 메소드 호출
*/
