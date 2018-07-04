//제네릭 클래스의 타입 인자를 인터페이스로 ㅔㅈ한하기
//
interface Eatable {
	public String eat();
}

class AppleB implements Eatable {
	public String toString() {
		return "I am an apple.";
	}
	
	@Override
	public String eat() {
		return "It tastes so good!";
	}
}

class BoxB<T extends Eatable> {
	private T ob;
	
	public void set(T o) {
		ob = o;
	}
	//한입 머고 반환하는 행위의 메소드 수정
	public T get() {
		System.out.println(ob.eat());
		return ob;
	}
}

public class B5_BoundedInterFaceBox {

	public static void main(String[] args) {
		BoxB<AppleB> box = new BoxB<>();
		box.set(new AppleB());

		AppleB ap = box.get();
		System.out.println(ap);

	}

}
