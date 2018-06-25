//지역변수 선언의 예 ( 같은영역내에서 동일이름 선언 불가 )
public class Local {

	public static void main(String[] args) {
		boolean ste = true;
		int num1 = 11;
		
		if(ste) {
			//int num1 = 22; //주석 해제하면 컴파일 오류발생
			num1++;
			System.out.println(num1);
		}
		{
			int num2 = 33;
			num2++;
			System.out.println(num2);
		}
		//System.out.println(num2);   // 주석 해제하면 컴파일 오류발생
	}

}
