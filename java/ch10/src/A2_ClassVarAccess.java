//클래스 변수 접근의 예
class AccessWay{
	static int num = 0;
	
	AccessWay() { incrCnt(); }
	void incrCnt() {
		 //클래스 내부에서 이름을 통한 접근.
		num++;    
	}
}

class A2_ClassVarAccess {
	public static void main(String[] args) {
		
		//인스턴스의 이름을 통한 접근(거의 사용하지않음)
		AccessWay way = new AccessWay();
		way.num++;
		System.out.println("num = " + AccessWay.num);
		
		//클래스의 이름을 통한 접근(이걸로 사용자주함)
		AccessWay.num++;
		System.out.println("num = " + AccessWay.num);
	}
}
