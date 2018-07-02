// 폴더가있으면 Simple.txt 를 생성함. 

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class D1_IOException {

	public static void main(String[] args) {
		Path file = Paths.get("c:\\javastudy\\Simple.txt");
		BufferedWriter writer = null;
		
		try {
			writer = Files.newBufferedWriter(file);  // IOException 발생 가능
			writer.write('김');   // IOException 발생 가능
			writer.write('현');   // IOException 발생 가능
			writer.write('승');   // IOException 발생 가능
			writer.write('짱');   // IOException 발생 가능
			
			if(writer != null)
				writer.close();   // IOException 발생 가능
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
