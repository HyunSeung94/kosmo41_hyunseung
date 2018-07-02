import java.util.Scanner;

public class Puzzle {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String arr[][] = {
				{"1","x","2"},
				{"7","6","3"},
				{"4","8","5"}
				}; 
		String temp ;
		String a ;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
			System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("[ Move ] a:Left s:Right w:Up z:Down");
		System.out.println("[ Exit ] k:Exit");

		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {

		if(arr[i][j] == "x") {
			a = s.next();
			if(a=="a") {
			temp = arr[i][j];
			arr[i][j-1]=arr[i][j];
			arr[i][j]= temp;
			
			}
		}	
		     }
		}System.out.println("1111");
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr.length; j++) {
				System.out.print(arr[i][j] +" ");
			}System.out.println();
		}
		

		
	}
}
