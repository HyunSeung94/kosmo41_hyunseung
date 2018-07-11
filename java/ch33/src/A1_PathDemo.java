//Paths와 path 클래스 
// 파일 및 디렉토리의 경로 표현을 위해 자바 7에서 추가된 인터페이스
import java.nio.file.Path;
import java.nio.file.Paths;

public class A1_PathDemo {

	public static void main(String[] args) {
		Path pt1 = Paths.get("C:\\javastudy\\PathDemo.java");
		Path pt2 = pt1.getRoot();
		Path pt3 = pt1.getParent();
		Path pt4 = pt1.getFileName();
		
		System.out.println("Absolute: " + pt1);
		System.out.println("Root: " + pt2);
		System.out.println("Parent: " +pt3);
		System.out.println("File: " + pt4);
	}

}

/*
Path getRoot() // 루트 디렉토리 반환
Path getParent() // 부모 디렉토리 반환
Path getFileName() // 파일 이름 반환
*/