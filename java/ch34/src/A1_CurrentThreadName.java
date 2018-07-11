//쓰레드의 이해와 쓰레드의 생성 방법
public class A1_CurrentThreadName {

	public static void main(String[] args) {
		Thread ct = Thread.currentThread();
		String name = ct.getName();    //쓰레드의 이름을 반환
		System.out.println(name);

	}

}
