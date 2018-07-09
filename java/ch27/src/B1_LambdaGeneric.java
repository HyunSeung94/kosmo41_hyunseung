//
// 함수형 인터페이스 : 추상 메서드가 딱 하나만 존재하는 인터페이스
//

@FunctionalInterface
interface Calculate <T> {
	T cal(T a, T b);
}
public class B1_LambdaGeneric {

	public static void main(String[] args) {
		Calculate<Integer> ci = (a, b) -> a + b;
		System.out.println(ci.cal(4, 3));
		
		Calculate<Double> cd = (a, b) -> a + b;
		System.out.println(cd.cal(4.32, 3.45));
	}

}
