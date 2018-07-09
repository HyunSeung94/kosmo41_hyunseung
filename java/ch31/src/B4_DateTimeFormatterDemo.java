import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class B4_DateTimeFormatterDemo {

	public static void main(String[] args) {
		ZonedDateTime date = ZonedDateTime.of(
		LocalDateTime.of(2019, 4, 25, 11, 20), ZoneId.of("Asia/Seoul"));
	   
		// 출력의 포맷 정보는 java.time.format.DateTimeFormatter 인스턴스에 담는다.
		DateTimeFormatter fm1 = DateTimeFormatter.ofPattern("yy-M-d");
		DateTimeFormatter fm2 = DateTimeFormatter.ofPattern("yyyy-MM-d, H:m:s");  //yyyy-MM에 m을 하나더 붙이면 우리나는 월이 뜬다. 
		DateTimeFormatter fm3 = DateTimeFormatter.ofPattern("yyyy-MM-d, a HH:mm:ss  VV"); // a를 붙이면 오전이면 오전 오후면 오후가 뜬다. 
		
		// LocalDate.LocalTime.LocalDateTime.ZonedDateTime에 모두 존재하는 format 메소드 호출한다.
		System.out.println(date.format(fm1));
		System.out.println(date.format(fm2));
		System.out.println(date.format(fm3));
		
	}

}

/*
y, M, d는 각각 년, 월, 일의 출력을 의미
H, m, s는 각각 시, 분, 초의 출력을 의미
VV는 시간대 ID의 출력을 의미
*/

