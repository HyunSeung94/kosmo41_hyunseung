
public class A2_MakeThreadDemo {

	public static void main(String[] args) {
		Runnable task = () -> { //쓰레드가 실행하게할 내용 
			try {
				Thread.sleep(3000);  // 시간지연 3초 
			}catch (Exception e) {
				
			}
			
			int n1 = 10;
			int n2 = 20;
			String name = Thread.currentThread().getName();
			System.out.println(name + ": " + (n1 + n2 ));
		};
		
		Thread t = new Thread(task);
		t.start();  // 쓰레드 생성 및 실행
		
		System.out.println("End " + Thread.currentThread().getName());
	}

}
/*
• 1단계 Runnable을 구현한 인스턴스 생성
• 2단계 Thread 인스턴스 생성
• 3단계 start 메소드 호출
*/