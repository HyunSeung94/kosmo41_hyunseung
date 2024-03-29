// 버퍼링 기능을 제공하는 필터 스트림. 
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class C3_BufferedStreamFileCopier {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("대상 파일: ");
		String src = sc.nextLine();
		System.out.println("사본 이름: ");
		String dst = sc.nextLine();
		
		try(BufferedInputStream in = new BufferedInputStream(new FileInputStream(src));
				BufferedOutputStream Out = new BufferedOutputStream(new FileOutputStream(dst))){
			int data;
			while(true) {
			data = in.read();
			if(data == -1)
			break;
			Out.write(data);
			}
			}
			catch(IOException e) {
			e.printStackTrace();
		}

	}

}
