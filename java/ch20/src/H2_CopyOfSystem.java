//arraycopy 메소드 호출의 예
public class H2_CopyOfSystem {

	public static void main(String[] args) {
		double[] org = {1.1, 2.2, 3.3, 4.4, 5.5};
		double[] cpy = new double[3];
		
		//미리 만들어져 있는 배열에 복사한다.
		System.arraycopy(org, 1, cpy, 0, 3);  //cpy 0번부터 출력을하고 org 1에서 3까지 출력
		
		for(double d: cpy)
			System.out.print(d+ "\t");
		System.out.println();
	}

}
