
/*서로다른 3자리의 랜덤숫자 만들기
 * 중복되는수가 나오면안됨.
 */
import java.util.Random;

class MyRandom
{
	void RandPrint1()
	{
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		
		Random rand = new Random();

		while (true) 
		{
			if ((num1 !=0) && (num1 != num2) && (num2 != num3) && (num3 != num1))
			{
				break;
			}
			//랜덤 숫자 구하기
			num1 = rand.nextInt(10);
			num2 = rand.nextInt(10);
			num3 = rand.nextInt(10);
		}
		System.out.println(num1 * 100 + num2 * 10 + num3);
		System.out.println((num1 + "" + num2 + "" + num3));
		
	}

	void RandPrint2()
	{
		int num  = 0;
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		
		Random rand = new Random();

		while (true)
		{
			if ((num1 != num2) && (num2 != num3) && (num3 != num1)) {
				break;
			}
			//랜덤 숫자 구하기
			num  = rand.nextInt(900)+100;  // 0~899 인데 (900)+100; 쓰면 100~899
			num1 = num / 100;
			num2 = (num - num1 * 100) / 10;
			num3 = num - num1 * 100 - num2 *10;
		}
		System.out.println(num1 * 100 + num2 * 10 + num3);
		System.out.println((num1 + "" + num2 + "" + num3));		
	}
}

public class Quiz15 {
	public static void main(String[] args) {
		// a * 100 + b * 10 * c
		// a != b
		// b != c
		// c != a
		// if ( ( a != b) && ( b !=c) && (c != a) )
		MyRandom rand = new MyRandom();
		rand.RandPrint1();
		System.out.println("----------");
		rand.RandPrint2();
	}

}
/*
 * Random random1 = new Random(); while (true) { int num1 = random1.nextInt(9) +
 * 1; int num2 = random1.nextInt(9); int num3 = random1.nextInt(9); if (num1 !=
 * num2 && num2 != num3 && num3 != num1) { System.out.print(num1);
 * System.out.print(num2); System.out.print(num3); break; } } } }
 * -------------------------------------------------------------위문항이내가한것
 * /* //Type #1 Random randomV1 = new Random();
 * 
 * System.out.println(randomV1.nextBoolean());
 * System.out.println(randomV1.nextFloat());
 * System.out.println(randomV1.nextInt());
 * System.out.println(randomV1.nextInt(100)); //range : 0 ~ 99
 * 
 * // Type #2 : 1~100 사이의 값 출력 double randomV2 = Math.random();
 * System.out.println("1 : " + randomV2); int intVal = (int)(randomV2 * 100) +
 * 1; System.out.println("2 : " + intVal); // (int)(Math.random() * (최대값 - 최소값 +
 * 1)) + 최소 }
 * 
 * }
 */