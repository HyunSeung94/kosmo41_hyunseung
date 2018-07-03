//오차 없는 실수 표현위한 BigDecimal 클래스! 
import java.math.BigDecimal;

public class D2_WowBigDecimal {

	public static void main(String[] args) {
		BigDecimal d1 = new BigDecimal("1.6");
		BigDecimal d2 = new BigDecimal("0.1");
		System.out.println("덧셈 결과: " + d1.add(d2));
		System.out.println("곱셈 결과: " + d1.multiply(d2));
		}

	}


/*덧셈 public BigDecimal add(BigDecimal augend)
뺄셈 public BigDecimal subtract(BigDecimal subtrahend)
곱셈 public BigDecimal multiply(BigDecimal multiplicand)
나눗셈 public BigDecimal divide(BigDecimal divisor)*/