//���� 05-09  
//1���� 100���� �����߿��� ¦���� ���� ���϶�. �� do~while���� �̿��϶�

public class Quiz9 {

	public static void main(String[] args) {
		int num = 2;
		int sum = 0;

		do { 
			if  (num % 2 == 0 ) { 
				 sum = (sum + num);
				}
				num++;			 
			 }while(num <= 100);
		
		System.out.println(" 1 ~100 ���� ¦���� �� = "  + sum);

		}
}



