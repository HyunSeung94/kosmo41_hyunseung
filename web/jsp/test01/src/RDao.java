

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

//커넥션풀 적용! 

public class RDao {


	private static RDao instance = new RDao();
	DataSource dataSource = null;
	int listCount = 10; // 한페이지당 보여줄 게시물의 갯수
	int pageCount = 5; // 하단에 보여줄 페이지 리스트 갯수
	int searchcount = 0;
	

	private RDao() {
		try {
			// lookup 함수의 파라메터는 context.xml에 설정된
			// name(jdbc/Oracle11g)과 동일해야 한다.
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
			// 접속 정보만 가지고 있음
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static RDao getInstance() {
		return instance;
	}


	public void RWrite(String bName, String bTitle, String bContent,String boardname,HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		HttpSession session = null;
		session = request.getSession();
		
		String name = (String) session.getAttribute("name");
		String Memberid = (String) session.getAttribute("id");
		session.setAttribute("id", Memberid);
		session.setAttribute("name", name);
		
		String query = "insert into mvc_board " + "(bId,bName,bTitle,bContent, bGroup, bStep, bIndent,boardname,Memberid)" + " values "
				+ " ( mvc_board_seq.nextval, ?, ?, ?, mvc_board_seq.currval,0,0,?,?)";

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, bTitle);
			pstmt.setString(3, bContent);
			pstmt.setString(4, boardname);
			pstmt.setString(5, Memberid);
			int rn = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public ArrayList<RDto> Rlist(int curPage, String search, String condition, String boardnamelist) {

		ArrayList<RDto> dtos = new ArrayList<RDto>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String query = null;

		int nStart = (curPage - 1) * listCount + 1;
		int nEnd = (curPage - 1) * listCount + listCount;

		try {
			
			// 전체글 쿼리문 !
			con = dataSource.getConnection();
			if (search == null && boardnamelist == null) {
				System.out.println(boardnamelist + "전체글 쿼리문!!");
				query = "select * " + "  from ( " + "   select rownum num, A.*" + "     from ( " + "        select *"
						+ "          from mvc_board " + "         order by bgroup desc, bstep asc ) A "
						+ "    where rownum <= ? ) B" + " where B.num >= ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, nEnd);
				pstmt.setInt(2, nStart);
				resultSet = pstmt.executeQuery();
				
				//게시판글 쿼리문
			} 
			
			while (resultSet.next()) {
				int Rnum = resultSet.getInt("Rnum");
				String Rid = resultSet.getString("Rid");
				String Roomname = resultSet.getString("Roomname");
				String position = resultSet.getString("position");
				RDto dto = new RDto(int Rnum, String Rid, String Roomname, String position)
				dtos.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}

	public RBPageInfo articlePage(int curPage, String search, String condition, String boardnamelist) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet resultSet = null;
		String query = null;
		/*
		 * 공통으로사용하는 변수 상단으로 올림 int listCount = 10; // 한페이지당 보여줄 게시물의 갯수 int pageCount =
		 * 10; // 하단에 보여줄 페이지 리스트 갯수
		 */

		// 총 게시물의 갯수
		int totalCount = 0;

		try {
			con = dataSource.getConnection();

			//전체 게시물 페이징 
			if (search == null && boardnamelist == null) {
				query = "select count(*) as total from mvc_board ";
				pstmt = con.prepareStatement(query);
				resultSet = pstmt.executeQuery();
			}

			if (resultSet.next()) {
				totalCount = resultSet.getInt("total");
			}
			System.out.println("total : " + totalCount);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		// 총 페이지 수
		int totalPage = totalCount / listCount; //
		if (totalCount % listCount > 0) {
			totalPage++;
		}

		// 현재 보고 있는 페이지
		int mycurPage = curPage;
		if (mycurPage > totalPage)
			mycurPage = totalPage;
		if (mycurPage < 1)
			mycurPage = 1;

		// 시작 페이지
		int startPage = ((mycurPage - 1) / pageCount) * pageCount + 1;

		// 끝 페이지
		int endPage = startPage + pageCount - 1;
		if (endPage > totalPage) {
			endPage = totalPage;
		}

		BPageInfo pinfo = new BPageInfo();
		pinfo.setTotalCount(totalCount);
		pinfo.setListCount(listCount);
		pinfo.setTotalPage(totalPage);
		pinfo.setCurPage(mycurPage);
		pinfo.setPageCount(pageCount);
		pinfo.setStartPage(startPage);
		pinfo.setEndPage(endPage);

		return pinfo;
	}




	public void delete(String bId) {

		Connection con = null;
		PreparedStatement pstmt = null;
		String query = "delete from mvc_board where bId = ?";

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setInt(1, Integer.parseInt(bId)); // 스트링을 인티저로 바꿔줌
			int rn = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
