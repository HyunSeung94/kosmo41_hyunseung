
public class ContinueBasic {

	public static void main(String[] args) {
		int num = 0;
		int count = 0;
		
		while(num < 100) {
			num++;
			if(((num % 5) != 0) || ((num % 7) != 0))
			{		
				continue;
			}
			count++;
			System.out.println(num);  // 5와 7의 배수인 경우만 실행
		}
		System.out.println("count: " + count);

	}

}
