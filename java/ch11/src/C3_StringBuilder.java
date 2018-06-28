// StringBuilder
public class C3_StringBuilder {

	public static void main(String[] args) {
		//만자열 "123"이 저장된 인스턴스의 생성
		StringBuilder stbuf = new StringBuilder("123");
		
		stbuf.append(45678);    //append = 문자열의 덧 붙이기 (12345678)   
		System.out.println(stbuf.toString());
		stbuf.delete(0, 2);     //delete =  문자열 일부 삭제(345678)
		System.out.println(stbuf.toString());
		stbuf.replace(0, 3, "AB"); //replace = 문자열 일부 교체 (AB678)
		System.out.println(stbuf.toString());
		stbuf.reverse();   //reverse =  문자열 내용뒤집기 (876BA)
		System.out.println(stbuf.toString());
		
		String sub = stbuf.substring(2, 4); // substring 일부만 문자열로 반환(6B)
		System.out.println(sub);
	}

}
