import java.util.*;
public class text{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("단어 입력");
		String str = sc.next();
		char[] arr = new char[str.length()];
		
		for(int i=0;i<arr.length; i++){ 
			arr[i] = str.charAt(i);
		}
		
		int sw=0;
		for(int i=0; i<arr.length/2; i++) {
			if(arr[i]!=arr[arr.length-1-i]) {
				sw=-1;
				break;
			}
		}
		
		if(sw==0)
			System.out.println("회문입니다.");
		else
			System.out.println("회문이 아닙니다.");
	}
}



