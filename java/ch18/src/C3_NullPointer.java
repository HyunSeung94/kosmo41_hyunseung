class C3_NullPointer {

	public static void main(String[] args) {
		String str = null;
		System.out.println(str);   //null 출력
//		if(str != null) {    //넣으면 오류발생하지않음. 
		int len = str.length();    // Exception!
//		}
	}

}
