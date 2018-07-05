import java.util.Random;
public class MyRandom {

	public static void main(String[] args) {
		Random rand = new Random();
		int num, num1, num2 ;
		
		num = rand.nextInt(9)+1;
		num1 = rand.nextInt(10);
		num2 = rand.nextInt(10);
		
		while(true) {
			
			if(num != num1 && num1 != num2 && num2 != num ) {
				break;
			}
			
		}
		System.out.print(num*100 + num1*10 + num2);
	}

}