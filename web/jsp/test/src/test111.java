import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.StringTokenizer;

public class test111 {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		// 출력스트림을 순차적으로 얻어와서 해당 메세지를 출력한다.
		// Iterator<String> it = clientMap.keySet().iterator();
		// StringTokenizer t1 = new StringTokenizer(msg);
		// String roomname = t1.nextToken();
		//
		try {
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@ec2-52-79-250-121.ap-northeast-2.compute.amazonaws.com:1521:xe", "scott",
					"tiger");
			// ----------------------------------------------------
			String sql = "select id from 방1 ";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				System.out.println(rs.getString(1));
				// System.out.println(rs.getString(2));
			}

		} catch (SQLException sqle) {
			System.out.println("17");
			sqle.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException sqle) {
			}
		}

	}

}
