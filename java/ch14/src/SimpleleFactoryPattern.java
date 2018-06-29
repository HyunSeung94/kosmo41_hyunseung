//추상클래스사용1 
//추상클래스를 상속받았으므로 오버라이딩필수!!
//자식 객체를 부모 객체에 대입하기
//생성된 애가 남자인지 여자인지 중요하지 않고 난 생성된
//인간 객체의 프린트 기능만 쓸것이다.
//남자이면 남자애가 가진기능을 할것이고, 
//여자이면 여자애가 가진기능을 할것이다.
abstract class Human{
	abstract void print();
}

class Man extends Human{
	
	public void print () {
		System.out.println("남자 생성");

	}
}

class Woman extends Human {
	
	public void print() {
		System.out.println("여자 생성");		
	}
}

class HumanFactory{
	public static Human create(String str) {
		if(str == "남자") {        //Man 이나 Woman 이나 Human의 자식 객체이므로
			return new Man();     //부모 객체에 대입할 수 있다.대입하여 리턴

		 } else if (str == "여자") {
			 return new Woman();
		 }
		return null;
	}
}
public class SimpleleFactoryPattern {

	public static void main(String[] args) {
		Human h1 = HumanFactory.create("남자");
		h1.print();
		
		Human h2 = HumanFactory.create("여자");
		h2.print();

	}

}
