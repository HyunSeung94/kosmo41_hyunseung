//생성자를 만들면 디폴트를 만들이유가없다.
//같은 패키지안에 Calc.class가 생성되어있기 때문에 생략가능하고 다음클레스에 적용가능 
//class는 기능을 분리하기위해만듬.
//add라는 메소드사용
class Calc
{
	int x1 = 0;
	int x2 = 0;
	
	Calc(int n1, int n2)
	{
		x1 = x1 + n1;
		x2 = x2 + n2;
	}
	int Add(int n1, int n2) {
		int nResult = (n1  + n2);
		System.out.println(nResult);
		return nResult;
	}
	
}
public class Exam01 {

	public static void main(String[] args) {
		int num1 = 5;
		int num2 = 7;
		
		Calc myCal = new Calc(num1, num2);
		int num3 =myCal.Add(num1, num2);
		
		int num4 = num3 * 10 - 20;
		System.out.println(num4);
	}

}
