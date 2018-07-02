//인터페이스의 디폴트 메서드의 특징
// 자체로 완전한 메서드이다.(비록 인터페이스 안에 있다고 하더라도..)
//따라서 이를 구현하는 클래스에서 오버라이딩 하지 않아도 된다. 


interface Printable4{
	void print(String doc);
	default void printCMYK(String doc) {}
}

class Prn731Drv4 implements Printable4 {
	@Override
	public void print(String doc) {
		System.out.println("From MD-731 printer");
		System.out.println(doc);
	}
}

class Prn909Drv4 implements Printable4{
	@Override
	public void print(String doc) {
		System.out.println("From MD-909 black & white ver");
	}
	
	@Override
	public void printCMYK(String doc) {
		System.out.println("From MD-909 CMYK ver");
		System.out.println(doc);
	}
}
