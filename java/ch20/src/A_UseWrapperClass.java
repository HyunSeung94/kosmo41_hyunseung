//
// 기본 자료형의 값을 감싸는 래퍼 클래스
//
public class A_UseWrapperClass {

	public static void showData(Object obj) {// 인스턴스를 요구하는 메소드 이메소드를 통해서 
		System.out.println(obj);             //정수나 실수를 출력하려면 해당값을 인스턴스화 해야한다.
	}
	
	public static void main(String[] args) {
		//정수 3으로 채워진 래퍼 인스턴스 생성
		Integer iInst = new Integer(3);
		showData(iInst);
		
		//실수 7.15로 채워진 래퍼 인스턴스 생성 
		showData(new Double(7.15));
	}
}
