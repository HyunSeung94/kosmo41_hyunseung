//문자열 연결 시키기
class C1_StringConcat {

	public static void main(String[] args) {
 
		String st1 = "Coffee";
		String st2 = "Bread";

		String st3 = st1.concat(st2);// st1의 값과 st2의 값을 연결한것을 st3에 선언
		System.out.println(st3);
 
		String st4 = "Fresh".concat(st3);//Fresh의 문자열과 st3의 값을 연결하고 st4에 선언
		System.out.println(st4);
 }
}