//시간이 얼마나 걸렸지? : Instant 클래스
import java.time.Duration;
import java.time.Instant;

public class A1_InstantDemo {

	public static void main(String[] args) {
		Instant start = Instant.now();  //현재 시각 정보를 담음
		System.out.println("시작: " + start.getEpochSecond());
		//반환 값은 1970-01-01  00:00:00'을 기분으로 지나온 시간을 초
		//단위로 계산환 결과
		
		System.out.println("Time flies like an arrow. ");
		
		Instant end = Instant.now(); //현재 시각 정보를 담음 
		System.out.println("끝: " + end.getEpochSecond());
		
		Duration between = Duration.between(start, end); //두 시각의 차 계산
		// Duration은 시각차를 표현하기 위한 클래스
		
		System.out.println("밀리 초 단위 차: " + between.toMinutes());

	}

}

