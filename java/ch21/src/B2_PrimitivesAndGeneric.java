class Box<T>{
	private T ob;
	
	public void set(T o) {
		ob = o;
	}
	public T get() {
		return ob;
	}
}


public class B2_PrimitivesAndGeneric {
	public static void main(String[] args) {
		Box<Integer> iBox = new Box<Integer>();
		iBox.set(125);  //오토박싱진행 
		int num = iBox.get();  // 오토 언박싱 진행
		System.out.println(num);
	}

}
//타입 인자로 기본 자료형이 올수 없다. int(x) : Intger(O)
//래퍼클래스가 필요한 이유! 
