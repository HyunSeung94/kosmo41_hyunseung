class test{
public static void main(String[] args) {
 String str1 = new String("Simple String");
 String str2 = "The Best String";

 System.out.println(str1);
 System.out.println(str1.length());/// str1의 문자갯수를 출력한다.
 System.out.println(); // '개 행’

 System.out.println(str2);
 System.out.println(str2.length());/// str2의 문자갯수를 출력한다.
 System.out.println();

 showString("Funny String");
}
public static void showString(String str) {
 System.out.println(str);
 System.out.println(str.length());/// str의 문자갯수를 출력한다.
}
}