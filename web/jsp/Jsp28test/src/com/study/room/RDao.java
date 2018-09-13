package com.study.room;

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

	public void RWrite(String rid,String roomname,String position, HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		HttpSession session = null;
		session = request.getSession();

		roomname = (String) session.getAttribute("roomname");
		rid = (String) session.getAttribute("rid");
		String id = (String) session.getAttribute("id");
		session.setAttribute("id", id);
		session.setAttribute("Rid", rid);
		session.setAttribute("Roomname", roomname);
		System.out.println(rid+"1"+roomname+"2"+position);
		String query = "insert into room "
				+ "(Rnum,RId,Roomname,position)" + " values "
				+ " ( room_seq.nextval, ?, ?, ?)";

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, rid);
			pstmt.setString(2, roomname);
			pstmt.setString(3, position);
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

	public void Roomin(String id,String roomname,HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		HttpSession session = null;
		session = request.getSession();
		
		roomname = (String) session.getAttribute("roomname");
		String Rid = (String) session.getAttribute("id");
		session.setAttribute("id", Rid);
		session.setAttribute("Roomname", roomname);
		String query = "insert into chat "
				+ "(Id,Room)" + " values "
				+ " (?, ?)";

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, Rid);
			pstmt.setString(2, roomname);
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
	
	public ArrayList<RDto> Rlist(int curPage) {

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
//			System.out.println("이거안타니~");
				query = "select * " + "  from ( " + "   select rownum num, A.*" + "     from ( " + "        select *"
						+ "          from room " + "   ) A "
						+ "    where rownum <= ? ) B" + " where B.num >= ? ";
				pstmt = con.prepareStatement(query);
				pstmt.setInt(1, nEnd);
				pstmt.setInt(2, nStart);
				resultSet = pstmt.executeQuery();			
			while (resultSet.next()) {
//				System.out.println("이거안타는거지?");
				int rnum = resultSet.getInt("rnum");
				String rid = resultSet.getString("rid");
				String roomname = resultSet.getString("roomname");
				String position = resultSet.getString("position");
				RDto dto = new RDto(rnum,  rid, roomname, position);
				dtos.add(dto);
//				System.out.println("탓다!");
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

	public BPageInfo articlePage(int curPage) {

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

			// 전체 게시물 페이징

			query = "select count(*) as total from room ";
			pstmt = con.prepareStatement(query);
			resultSet = pstmt.executeQuery();

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

	public void delete(String rid,String roomname) {

		Connection con = null;
		PreparedStatement pstmt = null;
		System.out.println("rid:RDAO:"+rid);
		System.out.println("roomname:RDAO:"+roomname);
		String query = "delete from room where roomname = ? and rid = ?";

		try {
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, roomname);
			pstmt.setString(2, rid);
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
