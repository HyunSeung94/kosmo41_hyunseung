import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class D5_StringReader {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new FileReader("src.txt"))){
			String str;
			while(true) {
				str = br.readLine();   //한문장 읽어 들이기
				if(str ==null) // 다음문장이 없으면 null이나옴 
					break;
				System.out.println(str);
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
