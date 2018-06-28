//substring은 () 파라미터에 설정한 값부터 출력 한다.  
//substring은 () 파라미터에 설정값 A,B개를 넣으면 첫번째 A이상~B미만 까지 출력
public class C2_SubSting {

	public static void main(String[] args) {
		String st1 = "abcdefg";
		
		String st2 = st1.substring(2);  //인덱스 2 이후의 내용으로 문자열을 반환후 st2에 선언;
		System.out.println(st2);
		
		String st3 = st1.substring(2,4); // 인덱스 substring(2,4)는 인덱스 2~3 위치한 내용의 문자열 반환
		System.out.println(st3);
	}
}
