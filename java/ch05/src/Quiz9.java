
public class Quiz9 {

	public static void main(String[] args) {
		int num = 0;
		int sum = 0;
		do {
			 if ((num % 2) == 0 )
			num++;
			 sum = (sum + num);
		}while(num < 100);
		System.out.println(num);

	}

}
