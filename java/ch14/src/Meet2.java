//인터페이스는 상속관계가 아닌 클래스에 기능을 제공하는 구조.
//클래스와 비슷한 구조이지만, 정의와 추상 
//메서드만이 멤버가 될수 있다.
interface Greet1 {
	void greet();
}

interface Bye extends Greet1 {
	void bye();
}

class Greeting implements Bye {
	public void greet() {
		System.out.println("안녕하세요!");
	}

	public void bye() {
		System.out.println("안녕히 계세요");
	}
}

class Meet2 {
	public static void main(String[] args) {
		Greeting greeting = new Greeting();
		greeting.greet();
		greeting.bye();
	}
}
