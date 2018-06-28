// 상속  (자바.pdf) extends는 상속을 사용할때
class Book {
	String title;
	String genre;

	void printBook() {
		System.out.println("제  목 : " + title);
		System.out.println("장  르 : " + genre);
	}
}

class Nove1 extends Book {  // Nove1이 Book을 상속받다 
	String writer;

	void printNov() {
		printBook();
		System.out.println("저  자 : " + writer);
	}
}

class Magazine extends Book { // Magazine이 Book을 상속받다. 
	int day;

	void printMag() {
		printBook();
		System.out.println("발매일 : " + day + "일");
	}
}

public class Bookshelf {

	public static void main(String[] args) {
		Nove1 nov = new Nove1();
		nov.title = "구운몽";
		nov.genre = "고전문학";
		nov.writer = "김만중";

		Magazine mag = new Magazine();
		mag.title = "월간 자바 그림책";
		mag.genre = "컴퓨터";
		mag.day = 20;

		nov.printNov();
		System.out.println();
		mag.printMag();

	}

}
