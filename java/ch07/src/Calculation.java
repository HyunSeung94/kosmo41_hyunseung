//오버로딩  :하나의 클래스 내에 인수의 개수나형이 다른 동일한 이름의 메서드를 
//여러개 정의하는것.
class Calc2
{
	int add(int a, int b)
	{
		return a + b;
	}
}
class Calculation 
{
	//main() 메서드와 같은 오브젝트 내의 메서드에는 static을 붙인다.
	static void disp() {
		int nRtn;
		Calc2 calc = new Calc2();
		nRtn = calc.add(3, 9);
				
		System.out.println("3 + 9 = " + nRtn);
	}

	public static void main(String[] args) 
	{
		disp();
	}

}
