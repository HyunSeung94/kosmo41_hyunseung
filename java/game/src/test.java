import java.util.Arrays;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String arr[][] = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "9" } };
		String arr1[][] = { { "1", "2", "3" }, { "4", "5", "6" }, { "7", "8", "9" } };
		int a = 2;
		int b;
		int c=0;
		String change = "X";
		String change1 = "O";
		do {	
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					System.out.print(arr[i][j]);
					if (j < 2) {
						System.out.print(" | ");
					}
				}
				if (i < 2) {
					System.out.println();
					System.out.print("--|---|---");
					System.out.println();
				}	
			}
			System.out.println();
			if ((a % 2) == 0) {
				System.out.println("Player1, Please enter the number of the square ");
				System.out.println("where you want to place your X:");
				b = s.nextInt();
				if (b == 1) {
					arr[0][0] = change;
				}
				if (b == 2) {
					arr[0][1] = change;
				}
				if (b == 3) {
					arr[0][2] = change;
				}
				if (b == 4) {
					arr[1][0] = change;
				}
				if (b == 5) {
					arr[1][1] = change;
				}
				if (b == 6) {
					arr[1][2] = change;
				}
				if (b == 7) {
					arr[2][0] = change;
				}
				if (b == 8) {
					arr[2][1] = change;
				}
				if (b == 9) {
					arr[2][2] = change;
				}
			}
			if ((a % 2) != 0) {
				System.out.println("Player2, Please enter the number of the square ");
				System.out.println("where you want to place your O:");
				b = s.nextInt();
				if (b == 1) {
					arr[0][0] = change1;
				}
				if (b == 2) {
					arr[0][1] = change1;
				}
				if (b == 3) {
					arr[0][2] = change1;
				}
				if (b == 4) {
					arr[1][0] = change1;
				}
				if (b == 5) {
					arr[1][1] = change1;
				}
				if (b == 6) {
					arr[1][2] = change1;
				}
				if (b == 7) {
					arr[2][0] = change1;
				}
				if (b == 8) {
					arr[2][1] = change1;
				}
				if (b == 9) {
					arr[2][2] = change1;
				}
			}	
			for(int i=0; i<arr.length; i++) {
				for(int j=0; j<arr.length; j++) {
					if(arr[i][0] == "X" && arr[i][1] =="X" && arr[i][2] =="X") {
						c++;
					}
					if(arr[0][j] == "X" && arr[1][j] =="X" && arr[2][j] =="X") {
						c++;
					}
					if(arr[i][0] == "O" && arr[i][1] =="O" && arr[i][2] =="O") {
						c++; c++;
					}
					if(arr[0][j] == "O" && arr[1][j] =="O" && arr[2][j] =="O") {
						c++; c++;
					}
				}
			}	
			a++;
			if(a==11) {
				System.out.println("허용 한도가 초과되었습니다. 다시시작!!");
				arr = arr1; 
			}
			if(c==3) {
				System.out.println("Plater 1 has wonn");break;
			}
			if(c==6) {
				System.out.println("Player 2 has wonn");break;	
			}
		} while (true);

	}

}
