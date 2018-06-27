//선언된 클래스의 모든 인스턴스가 공유하는 클래스 변수 
class InstCnt{
	static int instNum = 0;      //클래스 변수 (static 변수)
//	  int instNum = 0;     // static 변수를 사요아지않아 생성수가 올라가지않는다. 
	InstCnt(){
		instNum++;
		System.out.println("인스턴스 생성: " + instNum);
	}
}
class A1_ClassVar {

	public static void main(String[] args) {
		InstCnt cnt1 = new InstCnt();
		InstCnt cnt2 = new InstCnt();
		InstCnt cnt3 = new InstCnt();
	}

}
