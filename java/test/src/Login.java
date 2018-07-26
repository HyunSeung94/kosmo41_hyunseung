import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
	
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String name = s.nextLine();
		try {
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@ec2-52-79-250-121.ap-northeast-2.compute.amazonaws.com:1521:xe", "scott", "tiger");
			Statement stmt = con.createStatement();

			// ---------------------------------------------------------
			StringBuffer sb = new StringBuffer();
			sb.append("create table test2 ( ");
			sb.append(" ID varchar(20), ");
			sb.append(" age number ) ");

			int updateCount = stmt.executeUpdate(sb.toString());
			System.out.println("createCount : " + updateCount);
			sb.setLength(0);
			sb.append("insert into test2 ");
			sb.append("values (name, 10)");
			updateCount = stmt.executeUpdate(sb.toString());
			System.out.println("insertCount : " + updateCount);
			stmt.close();
			con.close();
		} catch (SQLException sqle) {
			System.out.println("Connection Error");
			sqle.printStackTrace();
		}
	}

}
