import java.nio.file.Path;
import java.nio.file.Paths;

public class A2_CurrentDir {

	public static void main(String[] args) {
		Path cur = Paths.get("");   //현재 디렉토리 정보 '상대 경로' 형태로 담긴 인스턴스 생성
		String cdir;
		
		if(cur.isAbsolute()) {
			System.out.println("1111");
			cdir = cur.toString();
		}
		else {
			System.out.println("2222");
			cdir = cur.toAbsolutePath().toString();
		}
		System.out.println("Current dir: " +cdir);
	}

}
