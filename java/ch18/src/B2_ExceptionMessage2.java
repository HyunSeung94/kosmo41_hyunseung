class B2_ExceptionMessage2 {
	public static void md1(int n) {
		md2(n,0);   //이지점으로 md2로 부터 예외가 넘어온다.
	}
	public static void md2(int n1, int n2) {
		int r =n1 / n2 ; //예외 발생 지점
	}
	public static void main (String[] args) {
		try {
			md1(3);   //이 지점에서 md1으로부터 예외가 넘어온다.
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		System.out.println("Good bye");
	}

}